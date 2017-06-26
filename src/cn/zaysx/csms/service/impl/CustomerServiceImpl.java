package cn.zaysx.csms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zaysx.csms.dao.CustomerDAO;
import cn.zaysx.csms.model.Customer;
import cn.zaysx.csms.service.CustomerService;
import cn.zaysx.util.UUIDUtil;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Resource
	private CustomerDAO customerDAO;
	
	@Override
	public Customer active(String code) {
		
		return customerDAO.findByCode(code);
	}

	@Override
	public Customer findCusByCusrnameAndPassword(Customer customer, String type) {
		if("phone".equals(type)){
			return customerDAO.findByCusnameAndPwd(customer.getCusName(), customer.getCusPwd(), "cusPhone");
		}else if("email".equals(type)){
			return customerDAO.findByCusnameAndPwd(customer.getCusEmail(), customer.getCusPwd(), "cusEmail");
		}else{
			return customerDAO.findByCusnameAndPwd(customer.getCusName(), customer.getCusPwd(), "cusName");
		}
	}

	@Override
	public Customer existCustomer(String cusName) {
		
		return customerDAO.findByCusname(cusName);
	}

	@Override
	public void register(Customer customer) {
		customer.setCusEnable("1");
		customer.setCusLevel("青铜会员");
		String code = UUIDUtil.getUUID() + UUIDUtil.getUUID();
		customer.setCusCode(code);
		customerDAO.save(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDAO.update(customer);

	}

	@Override
	public Customer findByCid(Integer cusId) {
		
		return customerDAO.findOne(cusId);
	}

}
