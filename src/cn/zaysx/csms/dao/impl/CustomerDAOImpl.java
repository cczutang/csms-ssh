package cn.zaysx.csms.dao.impl;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import cn.zaysx.csms.dao.CustomerDAO;
import cn.zaysx.csms.model.Customer;

@Repository("customerDAO")
@SuppressWarnings("all")
public class CustomerDAOImpl extends BaseDAOImpl<Customer> implements CustomerDAO{

	@Override
	public void save(Customer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getObjectByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByCusname(String cusName) {
        String hql = "from Customer c where c.cusName = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, cusName);
        return (Customer) query.uniqueResult();
	}

	@Override
	public Customer findByCusnameAndPwd(String cusName, String cusPwd, String type) {
		String hql = "from Customer c where c."+type+" = ? and c.cusPwd = ?";
        Query query = this.getCurrentSession().createQuery(hql).
        		setParameter(0, cusName).
        		setParameter(1, cusPwd);
        return (Customer) query.uniqueResult();
	}

	@Override
	public Customer findByCode(String code) {
        String hql = "from Customer c where c.code = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, code);
        return (Customer) query.uniqueResult();
	}

	@Override
	public Customer findOne(Integer cusId) {
		String hql = "from Customer c where c.cusId = ?";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter(0, cusId);
        return (Customer) query.uniqueResult();
	}

}
