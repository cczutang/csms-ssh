package cn.zaysx.csms.controller;

import java.util.Date;
import java.util.List;
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
    
    //首页中点击一级分类查询商品
    @RequestMapping(value = "/findByCid/{cateId}/{page}")
    public String findByCid(@PathVariable("cateId") Integer cateId, @PathVariable("page") Integer page
            , Map<String, Object> map) {

        List<Product> products = productService.findByCateId(cateId, page);
        Integer count = productService.CountPageProductFromCategory(cateId);
        if (page > count) {
            page = 1;
        }
        map.put("products", products);
        //把当前的页数存放到map中
        map.put("page", page);
        //总共有多少页
        map.put("count", count);
        map.put("cateId", cateId);
        return "productList";
    }
}
