package cn.zaysx.csms.service;

import java.util.List;

import cn.zaysx.csms.model.CategorySecond;

public interface CategorySecondService {
	/**
	 * 查找多有二级分类，即公司名
	 * @return
	 */
	public List<CategorySecond> findCategorySecondList();
	
	/**
	 * 根据ID查找二级分类
	 * @param catesId
	 * @return
	 */
	public CategorySecond findCategorySecond(Integer catesId);
}
