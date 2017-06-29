package cn.zaysx.csms.model;

/**
 * 购物项
 * @author tangyajun
 *
 */
public class ShoppingCartItem {
	
	private Product product; // 购物项中商品信息
	private Float price = 1.0f;    //计算价格
	private int count; // 购买某种商品数量
	@SuppressWarnings("unused")
	private float subtotal; // 购买某种商品小计
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getSubtotal() {
		return count * getPrice();
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	
	
}
