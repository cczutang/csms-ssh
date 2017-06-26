package cn.zaysx.csms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sun.tracing.dtrace.ModuleAttributes;

import cn.zaysx.csms.model.Admin;
import cn.zaysx.csms.model.Customer;
import cn.zaysx.csms.model.Product;
import cn.zaysx.csms.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
    @ModelAttribute(value = "admin")
    public void getUser(@RequestParam(value = "mid", required = false) String mid, Map<String, Object> map) {
        if (mid != null) {
            Admin admin = adminService.findAdminByMid(mid);
            map.put("admin", admin);
        }
    }
    
    //管理员登录
	@RequestMapping(value = "adminLogin", method = RequestMethod.POST)
    public String adminLogin(@RequestParam(value = "managerName") String managerName, 
    		@RequestParam(value = "managerPwd") String managerPwd, HttpSession session) {
		
		Admin admin = adminService.checkAdmin(managerName, managerPwd);
        if (null == admin) {
            return "login";
        } else {
            session.setAttribute("admin", admin);
        }
        return "index";
    }
	
    //管理员list所有会员分页显示
    @RequestMapping(value = "listCustomer")
    public ModelAndView listCustomer(@RequestParam(value = "page") Integer page){
    	//会员总页数
		Integer count = adminService.countCustomer();
        if (page > count) {
            page = 1;
        }
        //分页查询会员
		List<Customer> listCustomer = adminService.listCustomer(page, 1);
		ModelAndView mod = new ModelAndView("admin_manager");
		mod.addObject("listCustomer", listCustomer);
		mod.addObject("count", count);
		mod.addObject("page", page);
    	return mod;
    }	
    
    //显示管理员信息
    @RequestMapping(value = "admin_info")
    public ModelAndView showAdminInfo(@RequestParam(value = "id", required = false) String id) {
    	ModelAndView mod = new ModelAndView("admin_text");
    	if (id != null) {
            Admin admin = adminService.findAdminByMid(id);
            mod.addObject("admin", admin);
        }
    	return mod;
    }
    
    //管理员更新会员信息
    @RequestMapping(value = "update_customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer
            ,  @RequestParam(value = "cusId")String cusId, HttpServletRequest request, String productCompany) {
        Customer oldCustomer = adminService.findUserByCid(cusId);
        customer.setCusImage(oldCustomer.getCusImage());
        customer.setCusGender(oldCustomer.getCusGender());
        customer.setCusPwd(oldCustomer.getCusPwd());
        customer.setCusAge(oldCustomer.getCusAge());
        customer.setSucNickName(oldCustomer.getSucNickName());
    	customer.setCusEnable("1");      
    	adminService.updateCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCustomer?page=1");
        return modelAndView;
    }
    
    //查找一个会员
    @RequestMapping(value = "admin_edit")
    public ModelAndView findCustomer(@RequestParam(value = "id")String id){
    	Customer customer = adminService.findUserByCid(id);
    	ModelAndView modelAndView = new ModelAndView("admin_edit");
    	if(customer == null){
    		modelAndView.addObject("msg", 0);
    	}		
    	modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    
}
