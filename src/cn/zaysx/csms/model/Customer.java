package cn.zaysx.csms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
	private String cusId;
	
	@Column(name="cusName")
	private String cusName;
	
	@Column(name="sucNickName")
	private String sucNickName;
	
	@Column(name="cusPwd")
	private String cusPwd;
	
	@Column(name="cusEmail")
	private String cusEmail;
	
	@Column(name="cusAge")
	private String cusAge;
	
	@Column(name="cusGender")
	private String cusGender;
	
	@Column(name="cusPhone")
	private String cusPhone;
	
	@Column(name="cusAddress")
	private String cusAddress;
	
	@Column(name="cusLevel")
	private String cusLevel;
	
	@Column(name="cusEnable")
	private String cusEnable;
	
	@Column(name="cusImage")
	private String cusImage;

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getSucNickName() {
		return sucNickName;
	}

	public void setSucNickName(String sucNickName) {
		this.sucNickName = sucNickName;
	}

	public String getCusPwd() {
		return cusPwd;
	}

	public void setCusPwd(String cusPwd) {
		this.cusPwd = cusPwd;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getCusAge() {
		return cusAge;
	}

	public void setCusAge(String cusAge) {
		this.cusAge = cusAge;
	}

	public String getCusGender() {
		return cusGender;
	}

	public void setCusGender(String cusGender) {
		this.cusGender = cusGender;
	}

	public String getCusPhone() {
		return cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public String getCusLevel() {
		return cusLevel;
	}

	public void setCusLevel(String cusLevel) {
		this.cusLevel = cusLevel;
	}

	public String getCusEnable() {
		return cusEnable;
	}

	public void setCusEnable(String cusEnable) {
		this.cusEnable = cusEnable;
	}

	public String getCusImage() {
		return cusImage;
	}

	public void setCusImage(String cusImage) {
		this.cusImage = cusImage;
	}
	
}
