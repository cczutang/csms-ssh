package cn.zaysx.csms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="coupon")
public class Coupon {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer couId;
	private Float couConsume;
	private Float couPrivilege;
	private Date couTime;
	
	/*@OneToOne
	@JoinColumn(name="cid")
	private Category category;*/
	
	// 用户的:外键
	@OneToOne(optional = false)
	@JoinColumn(name = "cateId", unique = true, nullable = false, updatable = false, insertable = false)
	private Category category;

	public Integer getCouId() {
		return couId;
	}

	public void setCouId(Integer couId) {
		this.couId = couId;
	}

	public Float getCouConsume() {
		return couConsume;
	}

	public void setCouConsume(Float couConsume) {
		this.couConsume = couConsume;
	}

	public Float getCouPrivilege() {
		return couPrivilege;
	}

	public void setCouPrivilege(Float couPrivilege) {
		this.couPrivilege = couPrivilege;
	}

	public Date getCouTime() {
		return couTime;
	}

	public void setCouTime(Date couTime) {
		this.couTime = couTime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
