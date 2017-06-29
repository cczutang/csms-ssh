package cn.zaysx.csms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.itemstyle.Normal;

import cn.zaysx.csms.service.ProductService;


@Service
public class ChartServiceImpl {
	
	@Resource
	private ProductService productService;
	
	public Option selectRemoveCauses(){	
		
		List<Map<String, Object>> listMap = productService.chartCount();
		
		Option option = new Option();
		
		option.title("各种类型电脑库存").tooltip(Trigger.axis).legend("库存（台）");
		//创建横轴
		option.xAxis(new ValueAxis().boundaryGap(0d, 0.01));
		
		//创建类目轴  
	    CategoryAxis category = new CategoryAxis(); 
	    
	    //柱状数据
	    Bar bar = new Bar("库存（台）");
	    
	    for(Map data: listMap){
	    	System.out.print(data.get("0"));
	    	category.data(data.get("0"));
	    	bar.data(data.get("1"));
	    }
	    //设置类目轴  
	    option.yAxis(category);
	    option.series(bar);  
	    
		return option;

	}
}
