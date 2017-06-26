package cn.zaysx.csms.service;

import cn.zaysx.csms.model.Customer;

public interface CustomerService {

	/**
	 * 根据激活码激活用户
	 * @param code
	 * @return
	 */
   public Customer active(String code);

   	/**
   	 * 根据type和密码查找用户
   	 * @param customer,type
   	 * @return
   	 */
   public Customer findCusByCusrnameAndPassword(Customer customer, String type);

   /**
    * 根据用户名退出
    * @param cusName
    * @return
    */
   public Customer existCustomer(String cusName);

   /**
    * 注册
    * @param customer
    */
   public void register(Customer customer);

   /**
    * 更新用户信息
    * @param customer
    */
   public void update(Customer customer);

   /**
    * 根据ID查找用户
    * @param cusId
    * @return
    */
   public Customer findByCid(Integer cusId);
}
