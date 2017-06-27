package cn.zaysx.csms.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import cn.zaysx.csms.dao.CategorySecondDAO;
import cn.zaysx.csms.model.Category;
import cn.zaysx.csms.model.CategorySecond;

@Repository("categorySecondDAO")
public class CategorySecondDAOImpl extends BaseDAOImpl<CategorySecond> implements CategorySecondDAO{

	@Override
	public Integer countCategorySecond() {
		String hql = "select count(*) from CategorySecond";
        return count(hql);
	}

	@Override
	public List<CategorySecond> findAll(Integer page) {
        String hql = "from CategorySecond";
        int rows = 15;
        int page1 = page;
        return find(hql, page1, rows);
	}

	@Override
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond group by catesName";
        return find(hql);
	}

	@Override
	public CategorySecond findOne(Integer cateId) {
		String hql = "from CategorySecond c where c.catesId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, cateId);
		return (CategorySecond) query.uniqueResult();
	}

}
