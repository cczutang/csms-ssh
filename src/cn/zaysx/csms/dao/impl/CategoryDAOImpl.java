package cn.zaysx.csms.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import cn.zaysx.csms.dao.CategoryDAO;
import cn.zaysx.csms.model.Category;

@Repository("categoryDAO")
@SuppressWarnings("all")
public class CategoryDAOImpl extends BaseDAOImpl<Category> implements CategoryDAO {

	@Override
	public Integer countCategory() {
		String hql = "select count(*) from Category";
        return count(hql);
	}

	@Override
	public List<Category> findAll(Integer page) {
        String hql = "from Category";
        int rows = 10;
        int page1 = page;
        return find(hql, page1, rows);
	}

	@Override
	public List<Category> findAll() {
		String hql = "from Category";
        return find(hql);
	}

	@Override
	public Category findOne(Integer cateId) {
		String hql = "from Category c where c.cateId = ?";
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, cateId);
		return (Category) query.uniqueResult();
	}

	@Override
	public Date queryPrivilegeTime(Integer cateId) {
		// TODO Auto-generated method stub
		return null;
	}


}
