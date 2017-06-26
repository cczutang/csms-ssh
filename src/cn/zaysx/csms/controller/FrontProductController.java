package cn.zaysx.csms.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zaysx.csms.model.Product;
import cn.zaysx.csms.service.ProductService;

@Controller
public class FrontProductController {
	
	@Resource
	private ProductService productService;
	//根据商品的pid查询商品
    @RequestMapping(value = "findByPid/{pid}", method = RequestMethod.GET)
    public String findByPid(@PathVariable("pid") Integer pid, Map<String, Object> map) {

        return "product";
    }
}
