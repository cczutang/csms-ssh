package cn.zaysx.csms.service;

import java.util.List;

import cn.zaysx.csms.model.Admin;
import cn.zaysx.csms.model.Customer;

public interface AdminService {
	
	public void updateAdmin(Admin admin);
	
	public Admin checkAdmin(String managerName, String managerPwd);
	
	public void deleteAdmin(Admin managerId);
	

	public List<Admin> findAdmin(Integer page);
	

	public Integer countAdmin();
	
	
	public void updateCustomer(Customer customer);
	
	public Admin checkCustomer(Customer customer);
	
	public void deleteCustomer(Customer customerId);
	
	public List<Customer> listCustomer(Integer page, Integer cusEnable);
	
	public Integer countCustomer();
	
	public Customer findUserByCid(String customerId);
	
	public Admin findAdminByMid(String managerId);
	
	public String test();
}
