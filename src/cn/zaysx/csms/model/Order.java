package cn.zaysx.csms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private int Id;
	
	@Column(name="orderId")
	private String orderId;
	
	@Column(name="orderName")
	private String orderName;
	
	@Column(name="orderType")
	private String orderType;
	
	@JoinColumn(name = "customerId")
	@ManyToOne
	private Customer customer;
	
	@Column(name="orderTime")
	private String orderTime;
	
	@Column(name="orderTotal")
	private double orderTotal;
	
	@Column(name="orderEMS")
	private String orderEMS;
	
	@Column(name="orderAddr")
	private String orderAddr;
	
	@Column(name="orderGods")
	private String orderGods;
	
	@Column(name="orderStatus")
	private String orderStatus;
	
	@Column(name="orderEnable")
	private Integer orderEnable;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getOrderEMS() {
		return orderEMS;
	}

	public void setOrderEMS(String orderEMS) {
		this.orderEMS = orderEMS;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getOrderGods() {
		return orderGods;
	}

	public void setOrderGods(String orderGods) {
		this.orderGods = orderGods;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderEnable() {
		return orderEnable;
	}

	public void setOrderEnable(Integer orderEnable) {
		this.orderEnable = orderEnable;
	}
	
	
}
