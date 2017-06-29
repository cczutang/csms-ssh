package cn.zaysx.csms.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zaysx.csms.model.Product;
import cn.zaysx.csms.model.ShoppingCartItem;
import cn.zaysx.csms.service.CustomerService;
import cn.zaysx.csms.service.ProductService;

@Controller
public class ShoppingCartController {
	
	@Resource
	private CustomerService customerService;
	
	@Resource
	private ProductService productService;
	//跳转到购物车
	@RequestMapping("myCart")
	public String gotoCart(){
		return "user/cart";
	}
	
	//添加商品至购物车
	@RequestMapping("addToCart")
	public String shopping(Integer count, Integer productId, HttpSession session,
			Map<String, Object> map){
		//取得加入商品对象
		Product product = productService.findByPid(productId);
		//计算当前商品价格
		Float finalPrice = Float.valueOf(((String) session.getAttribute("price")).replace(",", ""));
		
		//实例化ShoppingCartItem对象
		ShoppingCartItem scItem = new ShoppingCartItem();
		scItem.setCount(count);
		scItem.setProduct(product);
		scItem.setPrice(finalPrice);
		
		map.put("count", count);
		map.put("product", product);
		map.put("finalPrice", finalPrice);
		
		return "user/cart";
	}
	
	//清空购物车
	
	
	//购物车删除商品
	
}
