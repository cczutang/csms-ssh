package cn.zaysx.csms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.OrderDAO;
import cn.zaysx.csms.model.Order;
import cn.zaysx.csms.service.OrderService;

@Transactional
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Resource
    private OrderDAO orderDAO;
	
	@Override
	public void save(Order order) {
		orderDAO.save(order);
	}

	@Override
	public List<Order> findByCid(String cid, Integer page) {
		int rows = 10;
		return orderDAO.findPageByCid(cid, page, rows);
	}

	@Override
	public Order findByOid(String oid) {	
		return orderDAO.findByOid(oid);
	}

	@Override
	public void update(Order currOrder) {
		orderDAO.update(currOrder);
	}

	@Override
	public List<Order> findAll(Integer page) {
		int rows = 10;
        return orderDAO.findByPage(page, rows);
	}

	@Override
	public Integer findCountByCid(String cid) {
		//int rows = 10;
		return orderDAO.findCountByCid(cid);
	}

	@Override
	public Integer findCount() {
		
		return orderDAO.findCount();
	}


}
