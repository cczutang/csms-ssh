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
	public List<Product> findByType(String productType, Integer page) {
		
		return productDAO.findByType(productType, page);
	}

	@Override
	public List<Product> findByCompany(String productCompany, Integer page) {
		return productDAO.findByType(productCompany, page);
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
	public Integer findCount() {
		Integer count = productDAO.CountProduct();
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

}
