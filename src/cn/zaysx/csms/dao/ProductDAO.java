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
    
    /**
     * 根据二级分类查询商品
     *
     * @param catesId
     * @param page
     * @return
     */
    public List<Product> findByCategorySecondCatesId(Integer catesId, Integer page);

    /**
     * 根据一级分类查询商品
     *
     * @param cateId
     * @param page
     * @return
     */
    public List<Product> findByCategoryCateId(Integer cateId, Integer page);
    
    /**
     * 
     * @param cid
     * @return
     */
    public Integer CountPageProductFromCategory(Integer cateId);

    public Integer CountPageProductFromCategorySecond(Integer catesId);
}
