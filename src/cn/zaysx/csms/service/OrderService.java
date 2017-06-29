package cn.zaysx.csms.service;

import java.util.List;

import cn.zaysx.csms.model.Order;

public interface OrderService {
	// 业务层保存订单的方法
    public void save(Order order);

    // 业务层根据用户id查询订单,带分页查询.
    public List<Order> findByCid(String cid, Integer page);

    // 根据订单id查询订单
    public Order findByOid(String oid);

    // 业务层修改订单的方法:
    public void update(Order currOrder);

    // 业务层查询所有订单方法
    public List<Order> findAll(Integer page);
    
    //根据订单号查询订单
    public Integer findCountByCid(String cid);
    
    //统计订单数
    public Integer findCount();
}
