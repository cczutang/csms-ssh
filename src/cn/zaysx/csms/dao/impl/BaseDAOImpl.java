package cn.zaysx.csms.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.zaysx.csms.dao.BaseDAO;
import cn.zaysx.csms.model.Customer;

@Repository("baseDAO")
@SuppressWarnings("all")
public class BaseDAOImpl<T> implements BaseDAO<T> {
	
	@Autowired
    private SessionFactory sessionFactory;
	
    private Class<T> clz;
    
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
    
    private Class<T> getClz() {
        if (clz == null) {
            //获取泛型的Class对象
            clz = ((Class<T>)
                    (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
        }
        return clz;
    }
    
/*    public BaseDAOImpl(){
    	ParameterizedType pType=(ParameterizedType) this.getClass().getGenericSuperclass();
    	clz=(Class) pType.getActualTypeArguments()[0];
    	System.out.print(clz.getSimpleName());
    }
*/
	@Override
	public void save(T o) {
		sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(
				sessionFactory.getCurrentSession().get(clz, id));
	}

	@Override
	public void update(T o) {
		Assert.notNull(o, "对象不能为空");  
		sessionFactory.getCurrentSession().update(o);	
	}

	@Override
	public T getObjectByid(int id) {
		return (T) sessionFactory.getCurrentSession().get(clz, id);
	}

	@Override
	public List<T> getObjectALL() {
		return sessionFactory.getCurrentSession().createQuery("from "+clz.getSimpleName()).list();
	}

	@Override
	public List<T> getObjectByids(int ids) {
		return sessionFactory.getCurrentSession().createQuery("from"
				+ ""+clz.getSimpleName()+"where id in(:ids)").setParameter("ids", ids).list();
	}
	
	@Override
	public Integer count(String hql) {
        Query q = sessionFactory.getCurrentSession().createQuery(hql);
        List cc = q.list();
        Long a = (Long) cc.get(0);
        return a.intValue();
	}
	
	@Override
	public Integer count(String hql, String parm) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setParameter(0, parm);
		List cc = q.list();
		Long a = (Long) cc.get(0);
		return a.intValue();
	}

	@Override
	public Integer count(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
		    for (String key : params.keySet()) {
		        q.setParameter(key, params.get(key));
		    }
		}
		return (Integer) q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
	    Query q = this.getCurrentSession().createQuery(hql);
	    return q.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
	    Query q = this.getCurrentSession().createQuery(hql);
	    if (params != null && !params.isEmpty()) {
	        for (String key : params.keySet()) {
	            q.setParameter(key, params.get(key));
	        }
	    }
	    return q.executeUpdate();
	}
	
	@Override
    public List<T> find(String hql) {
        Query q = this.getCurrentSession().createQuery(hql);
        return q.list();
    }
	
	@Override
    public List<T> find(String hql, Map<String, Object> params) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.list();
    }

	@Override
    public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
        Query q = this.getCurrentSession().createQuery(hql);
        if (params != null && !params.isEmpty()) {
            for (String key : params.keySet()) {
                q.setParameter(key, params.get(key));
            }
        }
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }

	@Override
    public List<T> find(String hql, int page, int rows) {
        Query q = this.getCurrentSession().createQuery(hql);
        return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
    }	
}
