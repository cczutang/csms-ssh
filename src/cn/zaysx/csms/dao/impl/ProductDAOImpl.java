package cn.zaysx.csms.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.ProductDAO;
import cn.zaysx.csms.model.Product;

@Repository("productDAO")
@SuppressWarnings("all")
public class ProductDAOImpl extends BaseDAOImpl<Product> implements ProductDAO {

	private List<Product> Query(String parm, Integer page, String hql) {
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
            int inv = (Integer) obj[4] ;
            product.setProductInventory(inv);
            product.setProductImage((String) obj[5]);
            product.setProductDesc((String) obj[6]);
            product.setProductDate((String) obj[7]);
            product.setProductEnable((Integer) obj[8]);
            product.setProductCompany((String) obj[9]);
            product.setProductType((String) obj[10]);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByCompany(String productCompany, int page) {
		String hql = "from Product p where p.productCompany = ? and p.productEnable = 1";
        return Query(productCompany, page, hql);
	}

	@Override
	public List<Product> findByType(String productType, int page) {
		String hql = "from Product p where p.productType = ? and p.productEnable = 1";
        return Query(productType, page, hql);
	}

	@Override
	public Integer CountProduct() {
		String hql = "select count(*) from Product where productEnable = 1";
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

}
