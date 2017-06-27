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
@Table(name = "product")
public class Product {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer productId;
	
	@Column(name="productName")
    private String productName;
	
	@Column(name="productPrice")
    private double productPrice;
	
	@Column(name="productShopPrice")
    private double productShopPrice;
	
	@Column(name="productInventory")
    private Integer productInventory;
    
	@Column(name="productImage")
	private String productImage;
	
	@Column(name="productDesc")
    private String productDesc;
	
	@Column(name="productEnable")
    private Integer productEnable;
	
	@Column(name="productDate")
    private String productDate;
	
	@Column(name="productType")
    private String productType;
	
	// 二级分类的外键:使用二级分类的对象.
    @JoinColumn(name = "catesId")
    @ManyToOne
    private CategorySecond productCompany;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductShopPrice() {
		return productShopPrice;
	}

	public void setProductShopPrice(double productShopPrice) {
		this.productShopPrice = productShopPrice;
	}

	public Integer getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(Integer productInventory) {
		this.productInventory = productInventory;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Integer getProductEnable() {
		return productEnable;
	}

	public void setProductEnable(Integer productEnable) {
		this.productEnable = productEnable;
	}

	public String getProductDate() {
		return productDate;
	}

	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public CategorySecond getProductCompany() {
		return productCompany;
	}

	public void setProductCompany(CategorySecond productCompany) {
		this.productCompany = productCompany;
	}
	
	@Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productShopPrice=" + productShopPrice + ", productPrice="
                + productPrice + ", productImage=" + productImage + ", productDesc=" + productDesc + ", productType=" + productType + ", productDate=" + productDate
                + ", productCompany=" + productCompany + "]";
    }
}
