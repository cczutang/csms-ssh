package cn.zaysx.csms.dao;

import java.util.List;

import cn.zaysx.csms.model.Product;

public interface ProductDAO extends BaseDAO<Product>{
	/**
     * 查找最热的十个商品
     *
     * @return
     */
    public List<Product> findHot();

    /**
     * 查找最新的十个商品
     *
     * @return
     */
    public List<Product> findNew();

    /**
     * 根据公司查询产品
     * @param com
     * @return
     */
    public List<Product> findByCompany(String productCompany, int page);
    
    /**
     * 根据种类查找产品
     * @param type
     * @return
     */
    public List<Product> findByType(String productType, int page);
    
    /**
     *计算个数
     * @return
     */
    public Integer CountProduct(Integer productEnable);
    
    /**
     * 根据ID查找一个产品
     * @param pid
     * @return
     */
    public Product findOne(Integer productId);
    
    /**
     * 查找所有产品
     * @param page
     * @return
     */
    public List<Product> findAll(Integer page, Integer productEnable);
    
    /**
     * 根据种类返回页数
     * @param productId
     * @return
     */
    public Integer CountPageProductWithType(String productType);

    /**
     * 根据公司返回页数
     * @param productCompany
     * @return
     */
    public Integer CountPageProductWithCompany(String productCompany);
    
    /**
     * 通过禁用删除商品
     * @param productId
     */
    public int deleteProductToEnable(Integer productId);
    
    public List<Product> seaProductByLike(String likesql);
}
