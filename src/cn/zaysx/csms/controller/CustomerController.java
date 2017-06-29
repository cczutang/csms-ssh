package cn.zaysx.csms.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zaysx.csms.model.Customer;
import cn.zaysx.csms.service.CustomerService;

@Controller
public class CustomerController {
	@Resource
	private CustomerService customerService;
	
	@ModelAttribute
	public Customer getCustomer() {
	    return new Customer();
	}
	
    //用户退出
    @RequestMapping("/quit")
    public String quit(HttpSession session, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:index";
    }

    //用户登录@RequestParam(value = "type") String type, 
    @RequestMapping(value = "login")
    public String login(@ModelAttribute("customer") Customer customer, 
    		String checkcode, HttpSession session, Map<String, Object> map) {
        //从session中获取验证码
        String checkCode = (String) session.getAttribute("checkcode");
        //如果验证码不一致，直接返回到登陆的页面
        if (!checkCode.equalsIgnoreCase(checkcode)) {
            map.put("errorCheckCode", "errorCheckCode");
            return "user/login";
        }
        //判断是否存在用户
        Customer isExistUser = customerService.existCustomer(customer.getCusName());
        if (isExistUser == null) {
            map.put("notUser", "notUser");
            return "user/login";
        }
        //判断用户是否激活
        Customer c = customerService.existCustomer(customer.getCusName());
        if ("0".equals(c.getCusEnable())) {
            map.put("notActive", "notActive");
            return "user/login";
        }
        //判断用户名和密码是否都正确
        c = customerService.findCusByCusrnameAndPassword(customer, "name");
        if (c == null) {
            map.put("notPassword", "notPassword");
            return "user/login";
        }
        session.setAttribute("customer", c);
        return "redirect:main";
    }

    //跳转到用户登录
    @RequestMapping(value = "/userLogin")
    public String userLogin() {
        return "user/login";
    }
    
    //用户激活
    @RequestMapping(value = "/active/{code}")
    public String active(@PathVariable("code") String code, Map<String, Object> map) {
        //根据激活码去查询用户
    	Customer customer = customerService.active(code);
        if (customer == null) {
            map.put("notUser", "notUser");
            return "msg";
        }
        customer.setCusCode("");
        customer.setCusEnable("1");
        customerService.update(customer);
        map.put("activeSuccess", "activeSuccess");
        return "msg";
    }
}
