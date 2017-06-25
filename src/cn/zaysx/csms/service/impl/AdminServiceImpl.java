package cn.zaysx.csms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.AdminDAO;
import cn.zaysx.csms.model.Admin;
import cn.zaysx.csms.model.Customer;
import cn.zaysx.csms.service.AdminService;

@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public String test() {
		return "test";
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin checkAdmin(String managerName, String managerPwd) { 
		return adminDAO.findByAdminnameAndPassword(
				managerName, managerPwd);
	}
	
	@Override
	public void deleteAdmin(Admin managerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Admin> findAdmin(Integer page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer countAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Admin checkCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCustomer(Customer customerId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Customer> listCustomer(Integer page, Integer cusEnable) {
		
		return adminDAO.listCustomer(page, cusEnable);
	}

	@Override
	public Integer countCustomer() {
		
		return adminDAO.CountCustomer();
	}

	@Override
	public Customer findUserByCid(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin findAdminByMid(String managerId) {
		return adminDAO.findOne(managerId);
	}

}
