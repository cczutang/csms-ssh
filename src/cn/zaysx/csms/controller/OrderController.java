package cn.zaysx.csms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.zaysx.csms.model.Customer;
import cn.zaysx.csms.model.Order;
import cn.zaysx.csms.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//管理员查看订单
	@RequestMapping(value = "showOrder")
    public ModelAndView  showOrder(@RequestParam("page") Integer page){
		//订单总页数
		Integer count = orderService.findCount();
        if (page > count) {
            page = 1;
        }
        //分页查询订单
		List<Order> orders = orderService.findAll(page);
		ModelAndView mod = new ModelAndView("order_list");
		mod.addObject("orders", orders);
		mod.addObject("count", count);
		mod.addObject("page", page);
    	return mod;
    }
	
	//根据订单id查询订单
    @RequestMapping(value = "order_details")
    public String findByOid(@RequestParam("id") String id,
                            Map<String, Object> map) {
        Order order = orderService.findByOid(id);
        if(order == null)
        	map.put("msg", "系统暂无该订单！请核实后再进行查询！");
        map.put("order", order);
        
        return "order_details";
    }

    //用户查询订单
    @RequestMapping(value = "findOrderByCid/{page}")
    public String findOrderByUid(HttpSession session, Map<String, Object> map
            , @PathVariable("page") Integer page) {
        //从session获取user对象
        Customer customer = (Customer) session.getAttribute("user");
        if (customer == null) {
            map.put("notLogin", "notLogin");
            return "msg";
        }
        //查询总共有多少页的数据
        Integer count = orderService.findCountByCid(customer.getCusId());
        if (page > count) {
            page = 1;
        }
        //根据用户分页查询订单
        List<Order> orders = orderService.findByCid(customer.getCusId(), page);
        map.put("orders", orders);
        map.put("page", page);
        map.put("count", count);
        return "orderList";
    }
    
    //删除订单
    @RequestMapping(value = "order_delete")
    public String delByOid(@RequestParam("id") String id,
                            Map<String, Object> map) {
        Order order = orderService.findByOid(id);
        if(order == null)
        	map.put("msg", "系统暂无该订单！请核实后再进行查询！");

        order.setOrderEnable(0);
        orderService.update(order);       
        map.put("order", order);    
        return "order_list";
    }
    
    //管理员操作订单
    @RequestMapping(value = "order_op")
    public String opByOid(@RequestParam("op") String op,@RequestParam("id") String id, 
    		Map<String, Object> map) {
    	Order order = orderService.findByOid(id);
    	String orderStatus = order.getOrderStatus();
    	switch(op){
	    	case "stamp":{
	    		
	    		break;
	    	}
	    	case "confirm":{
	    		
	    		break;
	    	}
	    	case "prepare":{
	    		
	    		break;
	    	}
	    	case "send":{
	    		
	    		break;
	    	}
    	}
        return "order_details";
    }
}
