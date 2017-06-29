package cn.zaysx.csms.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.google.gson.Gson;

import cn.zaysx.csms.model.WebResult;
import cn.zaysx.csms.service.AdminService;
import cn.zaysx.csms.service.ProductService;
import cn.zaysx.csms.service.impl.ChartServiceImpl;

@Controller
public class ChartsController {
	
	@Resource
	private ProductService productService;
	
	@Resource
	private AdminService adminService;
	
	@Resource
	private ChartServiceImpl chartService;
	/**
	 * 传递商品前台解析画图表
	 */

	@RequestMapping("admin/barChart")
	public @ResponseBody WebResult queryBarChart() {
		WebResult result = new WebResult();  
		Option option = chartService.selectRemoveCauses();  
		result.isOK();
		result.setData(option);  
		
		System.out.print(result.getMsg());
	    return result;  
	}
	
	//controller中返回json用了@ResponseBody，
	//而spring源码中@ResponseBody 的实现类发现其默认的编码是 iso-8859-1，而项目用的编码为utf-8,所以传中文会出现乱码。
	@RequestMapping(value = "barChartJson", produces = "application/json; charset=utf-8")
	public @ResponseBody String queryBarChartJson() {  
		Option option = chartService.selectRemoveCauses();  
		Gson gson = new Gson();
		String json = gson.toJson(option); 
	    return json;  
	}
	
	/**
	 * 传递订单前台解析画图
	 */
	public void orderChart(){
		
	}
}
