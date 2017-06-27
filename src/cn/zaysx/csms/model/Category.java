package cn.zaysx.csms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
	private int cateId;
	
    @Column(name = "cateName")
	private String cateName;
	
    @Column(name = "cateHappyHour")
	private Date cateHappyHour;
    
    //一级分类中存放二级分类的集合
    @OrderBy(value = "catesId")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();

    // coupon 外键
    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "category")
    private Coupon coupon;

	public int getCateId() {
		return cateId;
	}

	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Date getCateHappyHour() {
		return cateHappyHour;
	}

	public void setCateHappyHour(Date cateHappyHour) {
		this.cateHappyHour = cateHappyHour;
	}

	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	public Coupon getCoupon() {
		return coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

}
