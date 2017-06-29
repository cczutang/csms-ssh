package cn.zaysx.csms.dao;

import java.util.List;
import java.util.Map;

import cn.zaysx.csms.model.FullCalendar;
import cn.zaysx.csms.model.Order;

public interface OrderDAO extends BaseDAO<Order>{
	/**
     * DAO层查询我的订单分页查询:统计个数
     *
     * @param cid
     * @return
     */
    public int findCountByCid(String cid);

    /**
     * Dao层查询我的订单分页查询:查询数据
     *
     * @param cid
     * @param begin
     * @param limit
     * @return
     */
    public List<Order> findPageByCid(String cid, int begin, int limit);

    /**
     * DAO层根据订单id查询订单
     *
     * @param oid
     * @return
     */
    public Order findByOid(String oid);

    /**
     * DAO中统计订单个数的方法
     *
     * @return
     */
    public int findCount();

    /**
     * DAO中分页查询订单的方法
     *
     * @param begin
     * @param limit
     * @return
     */
    public List<Order> findByPage(int begin, int limit);

    public List<FullCalendar> orderTotal(String type);

}
