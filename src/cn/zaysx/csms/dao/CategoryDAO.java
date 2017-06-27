package cn.zaysx.csms.dao;

import java.util.Date;
import java.util.List;

import cn.zaysx.csms.model.Category;

public interface CategoryDAO extends BaseDAO<Category>{
	/**
     * 查询一级分类的总的个数
     *
     * @return
     */
    public Integer countCategory();

    /**
     * 分页查找所有用户
     *
     * @param page
     * @return
     */
    public List<Category> findAll(Integer page);

    public List<Category> findAll();

    public Category findOne(Integer cateId);

    /**
     * 查询优惠时间
     *
     * @param cateId
     * @return
     */
    public Date queryPrivilegeTime(Integer cateId);
}
