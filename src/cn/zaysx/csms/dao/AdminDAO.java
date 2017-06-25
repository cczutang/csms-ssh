package cn.zaysx.csms.dao;

import java.util.List;

import cn.zaysx.csms.model.Admin;
import cn.zaysx.csms.model.Customer;

public interface AdminDAO {
    public Admin findByAdminnameAndPassword(String managerName, String managerPwd);

    public Admin findOne(String managerId);
    
    public List<Customer> listCustomer(Integer page, Integer cusEnable);
    
    public Integer CountCustomer();
}
