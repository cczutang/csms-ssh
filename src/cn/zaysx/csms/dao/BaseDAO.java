package cn.zaysx.csms.dao;

import java.util.List;
import java.util.Map;

public interface BaseDAO<T> {
	
	//保存对象
	public void save(T o);
	
	//删除对象
	public void delete(int id);
	
	//更新对象
    public void update(T o);
    
    //根据ID查找对象
    public T getObjectByid(int id);
    
    //查询所有对象
    public List<T> getObjectALL();
    
    //根据一组id查询一组对象
    public List<T> getObjectByids(int ids);
    
    public List<T> find(String hql);

    public List<T> find(String hql, Map<String, Object> params);

    public List<T> find(String hql, int page, int rows);

    public List<T> find(String hql, Map<String, Object> params, int page, int rows);
    
    public Integer count(String hql);

    public Integer count(String hql, String parm);

    public Integer count(String hql, Map<String, Object> params);

    public int executeHql(String hql);

    public int executeHql(String hql, Map<String, Object> params);
}
