package cn.zaysx.csms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.CategorySecondDAO;
import cn.zaysx.csms.model.CategorySecond;
import cn.zaysx.csms.service.CategorySecondService;


@Transactional
@Service("categorySecondService")
public class CategorySecondServiceImpl implements CategorySecondService {
	
	@Resource
	private CategorySecondDAO categorySecondDAO;
	
	@Override
	public List<CategorySecond> findCategorySecondList() {
		
		return categorySecondDAO.findAll();
	}

	@Override
	public CategorySecond findCategorySecond(Integer catesId) {
		return categorySecondDAO.findOne(catesId);
	}

}
