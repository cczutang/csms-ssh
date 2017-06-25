package cn.zaysx.csms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "manager")
@Entity
public class Admin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private String managerId;
    
    @Column(name="managerName")
	private String managerName;
    
    @Column(name="managerPwd")
   	private String managerPwd;
    
    public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	@Column(name="managerType")
	private String managerType;
    
    @Column(name="managerEnable")
	private int managerEnable;
    
    @Column(name="managerPhone")
	private String managerPhone;
    
    @Column(name="managerAddress")
	private String managerAddress;

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerType() {
		return managerType;
	}

	public void setManagerType(String managerType) {
		this.managerType = managerType;
	}

	public int getManagerEnable() {
		return managerEnable;
	}

	public void setManagerEnable(int managerEnable) {
		this.managerEnable = managerEnable;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerAddress() {
		return managerAddress;
	}

	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}
    
	
}
