package cn.zaysx.csms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.zaysx.csms.model.Category;
import cn.zaysx.csms.model.CategorySecond;
import cn.zaysx.csms.model.Product;
import cn.zaysx.csms.service.CategorySecondService;
import cn.zaysx.csms.service.CategoryService;
import cn.zaysx.csms.service.ProductService;

@Controller
public class ProdutController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategorySecondService categorySecondService;

/*	//条件查询并分页显示
	@RequestMapping(value = "findProduct")
    public ModelAndView  showProduct(@RequestParam("selectValue") String selectValue,
    		@RequestParam("inputValue") String inputValue,
    		@RequestParam("page") Integer page){
		ModelAndView mod = new ModelAndView("product_list");
		switch(selectValue){
			case "company":{
				Integer count = productService.CountPageProductCompany(inputValue);
		        if (page > count) {
		            page = 1;
		        }
				List<Product> listProduct = productService.findByCompany(inputValue, page);
				mod.addObject("listProduct", listProduct);
				mod.addObject("count", count);
				mod.addObject("page", page);
			}
			case "type":{
				Integer count = productService.CountPageProductType(inputValue);
		        if (page > count) {
		            page = 1;
		        }
				List<Product> listProduct = productService.findByType(inputValue, page);
				mod.addObject("listProduct", listProduct);
				mod.addObject("count", count);
				mod.addObject("page", page);
			}
			case "name":{
				
			}
			case "id":{
				Product product = productService.findByPid(Integer.valueOf(inputValue));
				mod.addObject("listProduct", product);
				mod.addObject("count", 1);
				mod.addObject("page", page);
			}
		}
    	return mod;
    }*/
	
	//分页显示商品
	@RequestMapping(value = "listProduct")
    public ModelAndView  showOrder(@RequestParam("page") Integer page,
    		@RequestParam("type") Integer type){
		//订单总页数
		Integer count = productService.findCount(type);
        if (page > count) {
            page = 1;
        }
        //分页查询订单
		List<Product> listProduct = productService.listProduct(page, type);
		ModelAndView mod = new ModelAndView("product_list");
		mod.addObject("listProduct", listProduct);
		mod.addObject("count", count);
		mod.addObject("page", page);
		mod.addObject("type", type);
    	return mod;
    }

	//查找商品进入详情页
	@RequestMapping(value = "product_edit")
    public ModelAndView  findById(@RequestParam("id") Integer productId){
		ModelAndView mod = new ModelAndView("product_edit");
		if(productId == 0){
			mod.addObject("msg", "0");
			return mod;
		}else{
			Product product = productService.findByPid(productId);
			mod.addObject("product", product);
			return mod;
		}
    }
	//更新商品之前update_product_before
    @RequestMapping(value = "update_product_before")
    public ModelAndView beforeUpdateProduct(@RequestParam("id")Integer id){ 	
    	ModelAndView modelAndView = new ModelAndView("product_edit");
    	List<CategorySecond> clist = categorySecondService.findCategorySecondList();
        List<Category> tlist = categoryService.getCategory();
        Product oldProduct = productService.findByPid(id);
        modelAndView.addObject("product", oldProduct);
    	modelAndView.addObject("clist", clist);
    	modelAndView.addObject("tlist", tlist);
    	return modelAndView;                              	
    }
	
	//修改商品
    @RequestMapping(value = "update_product")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product
            , @RequestParam("upload") CommonsMultipartFile upload
            , HttpServletRequest request, Integer catesId) {
        ServletContext servletContext = request.getSession().getServletContext();
        //查询该商品
        Product oldProduct = productService.findByPid(product.getProductId());

	    CategorySecond categorySecond = categorySecondService.findCategorySecond(catesId);
	    product.setProductCompany(categorySecond);
	    String type = categorySecond.getCatesName();
	    
        //从字符串截出该图片的名称
        int begin = oldProduct.getProductImage().lastIndexOf("/");
        String filename = oldProduct.getProductImage().substring(begin + 1, oldProduct.getProductImage().length());
        //获取文件的名称
        String uploadFilename = upload.getOriginalFilename();
        //如果上传的图片的名称和旧的照片不一致
        if (filename != uploadFilename && !"".equals(uploadFilename)) {
            //获取文件保存目录
            String path = servletContext.getRealPath("/upload/"+type);
            try {
                FileUtils.writeByteArrayToFile(new File(path, uploadFilename), upload.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            //重新设置文件的路径
            product.setProductImage("upload/"+type+"/" + uploadFilename);
            //更新商品的时间
            Date date = new Date();
            String sDate = (new SimpleDateFormat("yyyy-MM-dd")).format(date); 
            product.setProductDate(sDate);
            //删除旧的商品图片
            path = request.getSession().getServletContext().getRealPath("/" + oldProduct.getProductImage());
            File file = new File(path);
            file.delete();
        } else {
			Date date = new Date();
			String sDate = (new SimpleDateFormat("yyyy-MM-dd")).format(date); 
			product.setProductDate(sDate);
        }
        product.setProductEnable(1);      
        productService.update(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/listProduct?page=1&type=1");
        return modelAndView;
    }
	
	//添加商品add_product
    @RequestMapping(value = "add_product_before")
    public ModelAndView beforeAddProduct( ){
    	
    	ModelAndView modelAndView = new ModelAndView("product_add");
    	List<CategorySecond> clist = categorySecondService.findCategorySecondList();
        List<Category> tlist = categoryService.getCategory();
    	modelAndView.addObject("clist", clist);
    	modelAndView.addObject("tlist", tlist);
    	return modelAndView;                              	
    }
    
    //跳转到添加商品add_product
    @RequestMapping(value = "add_product", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product") Product product,
                                   @RequestParam("upload") CommonsMultipartFile upload, HttpServletRequest request,
                                    Integer catesId) {
    	String type = "other";
		if (catesId != null) {
		    //该商品所属的二级分类
		    CategorySecond categorySecond = categorySecondService.findCategorySecond(catesId);
		    product.setProductCompany(categorySecond);
		    type = categorySecond.getCatesName();
		}
    	//获取文件保存目录
        ServletContext servletContext = request.getSession().getServletContext();
        String path = servletContext.getRealPath("/upload/"+type);
        //获取文件的名称
        String filename = upload.getOriginalFilename();
        try {
            FileUtils.writeByteArrayToFile(new File(path, filename), upload.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置文件的路径
        product.setProductImage("upload/"+type+"/" + filename);
        //设置上传的时间
        Date date = new Date();
        String sDate = (new SimpleDateFormat("yyyy-MM-dd")).format(date); 
        product.setProductDate(sDate);
        product.setProductEnable(1);
        //保存商品
        productService.save(product);

        ModelAndView modelAndView = new ModelAndView("redirect:/listProduct?page=1&type=1");
        return modelAndView;
    }
	
    //删除商品
    @RequestMapping(value = "delete_product/{productId}")
    public ModelAndView deleteProduct(@PathVariable("productId") Integer productId, HttpServletRequest request) {
        //删除该商品
        int rs = productService.delProductByEnable(productId);
        	
        ModelAndView modelAndView = new ModelAndView("redirect:/listProduct?page=1");
        if(rs>0)
        	modelAndView.addObject("msg", "删除成功！");
        return modelAndView;
    }
    
    //预览商品
    
    
    
}
