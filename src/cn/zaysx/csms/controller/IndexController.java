package cn.zaysx.csms.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zaysx.csms.service.CategoryService;
import cn.zaysx.csms.service.ProductService;

@Controller
public class IndexController {
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private ProductService productService;
	
	//商品首页的action
	@RequestMapping(value = "/main")
	public String showIndex(Map<String, Object> map, HttpSession session) {
	
	System.out.print("index");
	//把所有的一级分类都存入到session中
	session.setAttribute("cList", categoryService.getCategory());
	//把最新的10条商品存放到map集合中
	map.put("nList", productService.findNew());
	return "user/index";
	}
}
