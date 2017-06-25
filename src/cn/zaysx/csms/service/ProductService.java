package cn.zaysx.csms.service;

import java.util.List;

import cn.zaysx.csms.model.Product;

public interface ProductService {

    //分页查询商品
    public List<Product> listProduct(Integer page, Integer productEnable);
	
    // 根据分类查询商品
    public List<Product> findByType(String productType, Integer page);
    
    // 根据商家查询商品
    public List<Product> findByCompany(String productCompany, Integer page);
    

    // 查找最热的商品10条
    public List<Product> findHot();

    // 查找最新的商品10条
    public List<Product> findNew();

    // 根据商品的pid的值查询商品
    public Product findByPid(Integer productId);

    // 返回分类有多少页的数据
    public Integer CountPageProductType(String productType);
    
    //返回公司有多少页数据
    public Integer CountPageProductCompany(String productCompany);
    
    // 更新商品的信息
    public void update(Product product);

    // 保存商品信息
    public void save(Product save);
    
    //查找所有
    public Integer findCount();
    
    public int delProductByEnable(Integer productId);
}
