package cn.zaysx.csms.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.OrderDAO;
import cn.zaysx.csms.model.FullCalendar;
import cn.zaysx.csms.model.Order;

@Repository("orderDAO")
@SuppressWarnings("all")
public class OrderDAOImpl extends BaseDAOImpl<Order> implements OrderDAO {
	
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
	public int findCountByCid(String cid) {
		 String hql = "select count(*) from Order o where o.customer.customerId = :id and o.orderEnable = 1";
	        Query query = this.getCurrentSession().createQuery(hql).
	        		setParameter("id", cid);
	        List<Long> list = query.list();
	        if (list != null && list.size() > 0) {
	            return list.get(0).intValue();
	        }
	        return 0;
	}

	@Override
	public List<Order> findPageByCid(String cid, int begin, int limit) {
		String hql = "from Order o where o.customer.customerId = :id and o.orderEnable = 1 order by o.orderTime desc";
		Query query = this.getCurrentSession().createQuery(hql).
				setParameter("id", cid);
		List<Order> list = query.setFirstResult((begin - 1) * limit).setMaxResults(limit).list();
		if (list != null && list.size() > 0) {
		    return list;
		}
		return null;
	}
	
	/**
	 * 根据订单号查找订单，并返回该订单信息
	 */
	@Override
	public Order findByOid(String oid) {
		String hql = "from Order o where o.orderId = :orderId and o.orderEnable = 1";
        Query query = this.getCurrentSession().createQuery(hql).
        		setParameter("orderId", oid);
        return (Order) query.uniqueResult();
	}
	
	/**
	 * 查找所有订单，返回订单个数
	 */
	@Override
	public int findCount() {
		String hql = "select count(*) from Order where orderEnable = 1";
		Query query = this.getCurrentSession().createQuery(hql);
		List<Long> list = query.list();
		if (list != null && list.size() > 0) {
		    Integer count = list.get(0).intValue();
		    return (count % 10 == 0 ? (count / 10) : (count / 10 + 1));
		}
		return 0;
	}
	
	/**
	 * 分页查找，返回订单列表
	 */
	@Override
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order o where o.orderEnable = 1 order by o.orderTime desc";
        Query query = this.getCurrentSession().createQuery(hql);
        return query.setFirstResult((begin - 1) * limit).setMaxResults(limit).list();
	}

	@Override
	public List<FullCalendar> orderTotal(String type) {
		String hql = "select count(Id), sum(orderTotal), orderTime from orders where orderType='正常' and orderStatus='已签收' and orderEnable=1 group BY orderTime ORDER BY orderTime";
		
		return null;
	}

}
