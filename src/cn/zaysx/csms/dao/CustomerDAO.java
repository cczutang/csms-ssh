package cn.zaysx.csms.dao;

import cn.zaysx.csms.model.Customer;

public interface CustomerDAO extends BaseDAO<Customer>{

    public Customer findByCusname(String cusName);


    public Customer findByCusnameAndPwd(String cusName, String cusPwd, String type);


    public Customer findByCode(String code);

    public Customer findOne(Integer cusId);
}
