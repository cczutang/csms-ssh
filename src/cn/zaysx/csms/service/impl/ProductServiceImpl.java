package cn.zaysx.csms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.ProductDAO;
import cn.zaysx.csms.model.Product;
import cn.zaysx.csms.service.ProductService;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Resource
    private ProductDAO productDAO;
	

	@Override
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findNew() {
		
		return productDAO.findNew();
	}

	@Override
	public Product findByPid(Integer productId) {
		return productDAO.findOne(productId);
	}

	@Override
	public Integer CountPageProductType(String productType) {
		Integer count = productDAO.CountPageProductWithType(productType);
        return (count % 5 == 0 ? (count / 5) : (count / 5 + 1));
	}

	@Override
	public Integer CountPageProductCompany(String productCompany) {
		Integer count = productDAO.CountPageProductWithCompany(productCompany);
        return (count % 5 == 0 ? (count / 5) : (count / 5 + 1));
	}

	@Override
	public void update(Product product) {
		productDAO.update(product);
	}

	@Override
	public void save(Product save) {
		productDAO.save(save);
	}

	@Override
	public Integer findCount(Integer productEnable) {
		Integer count = productDAO.CountProduct(productEnable);
		return (count % 5 == 0 ? (count / 5) : (count / 5 + 1));
	}

	@Override
	public List<Product> listProduct(Integer page, Integer productEnable) {
		return productDAO.findAll(page, productEnable);
	}

	@Override
	public int delProductByEnable(Integer productId) {
		return productDAO.deleteProductToEnable(productId);
	}

	@Override
	public List<Product> findByCatesId(Integer catesId, Integer page) {
		
		return productDAO.findByCategorySecondCatesId(catesId, page);
	}

	@Override
	public List<Product> findByCateId(Integer cateId, Integer page) {
		return productDAO.findByCategoryCateId(cateId, page);
	}

	@Override
	public Integer CountPageProductFromCategory(Integer cateId) {
		Integer count = productDAO.CountPageProductFromCategory(cateId);
        return (count % 12 == 0 ? (count / 12) : (count / 12 + 1));
	}

	@Override
	public Integer CountPageProductFromCategorySecond(Integer catesId) {
		Integer count = productDAO.CountPageProductFromCategorySecond(catesId);
        return (count % 12 == 0 ? (count / 12) : (count / 12 + 1));
    }

}
