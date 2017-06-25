package cn.zaysx.csms.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.AdminDAO;
import cn.zaysx.csms.model.Admin;
import cn.zaysx.csms.model.Customer;
import cn.zaysx.csms.model.Order;
import cn.zaysx.csms.model.Product;

@Repository("adminDAO")
@SuppressWarnings("all")
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
	@Override
	public Admin findByAdminnameAndPassword(String managerName, String managerPwd) {
		String hql = "from Admin a where a.managerName = :name and a.managerPwd = :pwd";
		Query query = this.getCurrentSession().createQuery(hql).
				setParameter("name", managerName).
				setParameter("pwd", managerPwd);

		return (Admin) query.uniqueResult();
	}

	@Override
	public Admin findOne(String managerId) {
		String hql = "from Admin where managerId=:id";
        Query query = this.getCurrentSession().createQuery(hql).
        		setParameter("id", managerId);
        return (Admin) query.uniqueResult();
	}

	@Override
	public List<Customer> listCustomer(Integer page, Integer cusEnable) {
		String hql = "from Customer c where c.cusEnable = "+cusEnable;
        int rows = 5;
        int page1 = page;
        Query query = this.getCurrentSession().createQuery(hql);
        return query.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Integer CountCustomer() {
		String hql = "from Customer where cusEnable = 1";
		Query query = this.getCurrentSession().createQuery(hql);
		List<Customer> list = query.list();
        return list.size();
	}

}
