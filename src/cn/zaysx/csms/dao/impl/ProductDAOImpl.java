package cn.zaysx.csms.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.ProductDAO;
import cn.zaysx.csms.model.Product;

@Repository("productDAO")
@SuppressWarnings("all")
public class ProductDAOImpl extends BaseDAOImpl<Product> implements ProductDAO {

	
	@Autowired
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
	
	final String selecthql = "select p.productId,p.productName,"
	            + "p.productPrice,p.productShopPrice,p.productImage,"
	            + "p.productDesc,p.productDate,p.productEnable,productType ";
	
	private List<Product> Query(Integer parm, Integer page, String hql) {
        int rows = 5;
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, parm);
        List list = query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();

        List<Product> products = new ArrayList<Product>();
        Iterator iter = list.iterator();

        while (iter.hasNext()) {

            Object[] obj = (Object[]) iter.next();
            Product product = new Product();

            int pid = (Integer) obj[0];
            product.setProductId(pid);
            product.setProductName((String) obj[1]);
            product.setProductPrice((double) obj[2]);
            product.setProductShopPrice((double) obj[3]);
            product.setProductImage((String) obj[4]);
            product.setProductDesc((String) obj[5]);
            product.setProductDate((String) obj[6]);
            product.setProductEnable((Integer) obj[7]);
            product.setProductType((String) obj[8]);
            products.add(product);
        }
        return products;
    }
	
	@Override
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findNew() {
		String hql = "from Product order by length(productDate)";
		int rows = 10;
	    return find(hql, 1, rows);
	}
	
	@Override
	public Integer CountProduct(Integer productEnable) {
		String hql = "select count(*) from Product where productEnable ="+productEnable;
        return count(hql);
	}


	@Override
	public Product findOne(Integer productId) {
		String hql = "from Product p where p.productId = :id and p.productEnable = 1";
		Query query = this.getCurrentSession().createQuery(hql).
				setParameter("id", productId);
		return (Product) query.uniqueResult();
	}

	@Override
	public List<Product> findAll(Integer page, Integer productEnable) {
		String hql = "from Product where productEnable = "+productEnable;
        int rows = 5;
        int page1 = page;
        return find(hql, page1, rows);
	}

	@Override
	public Integer CountPageProductWithType(String productType) {
		String hql = "select count(*) from Product p "
				+ "where p.productType = ? and p.productEnable = 1";
        return count(hql, productType);
	}

	@Override
	public Integer CountPageProductWithCompany(String productCompany) {
		String hql = "select count(*) from Product p "
				+ "where p.productCompany = ? and p.productEnable = 1";
        return count(hql, productCompany);
	}

	@Override
	public int deleteProductToEnable(Integer productId) {
		String hql = "update Product p set "
				+ "p.productEnable = 0 where p.productId = '"+productId+"'";
		return executeHql(hql);	
	}

	@Override
	public List<Product> seaProductByLike(String likesql) {
		
		return null;
	}

	@Override
	public List<Product> findByCategorySecondCatesId(Integer catesId, Integer page) {
		String hql = selecthql + "from Product p ,CategorySecond cs ";
	    hql += "where p.productCompany.catesId = cs.catesId and cs.catesId = ?";
	    return Query(catesId, page, hql);
	}

	@Override
	public List<Product> findByCategoryCateId(Integer cateId, Integer page) {
		String hql = selecthql + "from Product p,Category c, CategorySecond cs ";
        hql += "where p.productCompany.catesId = cs.catesId and cs.category.cateId = c.cateId and c.cateId = ?";
        return Query(cateId, page, hql);
	}

	@Override
	public Integer CountPageProductFromCategory(Integer cateId) {
		String hql = "select count(*) from Product p, Category c, CategorySecond cs ";
		hql += "where p.productCompany.catesId = cs.catesId and cs.category.cateId = c.cateId and c.cateId = ?";
		return count(hql, cateId+"");
	}

	@Override
	public Integer CountPageProductFromCategorySecond(Integer catesId) {
		String hql = "select count(*) from Product p ,CategorySecond cs ";
	    hql += "where p.productCompany.catesId = cs.catesId and cs.catesId = ?";
	    return count(hql, catesId+"");
	}

	@Override
	public List<Map<String, Object>> chartCount() {
		String hql = "select new map(productType, sum(productInventory)) from Product group by productType";	
		Query q = this.getCurrentSession().createQuery(hql);
	    return q.list();
	}

}
