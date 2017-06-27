package cn.zaysx.csms.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.zaysx.csms.dao.CategoryDAO;
import cn.zaysx.csms.model.Category;
import cn.zaysx.csms.service.CategoryService;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
	
	@Resource
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getCategory() {
		
		return categoryDAO.findAll();
	}
	
}
