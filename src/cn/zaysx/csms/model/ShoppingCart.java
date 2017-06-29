package cn.zaysx.csms.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {
	//购物车属性
	//购物项集合：Map的key就是商品productId，value：购物项
	private Map<Integer, ShoppingCartItem> map = new LinkedHashMap<Integer, ShoppingCartItem>();
	
	//Cart对象中有一个cartItems属性
	public Collection<ShoppingCartItem> getCartItems(){
		return map.values();
	}
	
	//购物总计
	private float total;
	
	public float getTotal() {
		return total;
	}
	
	public void setTotal(float total) {
		this.total = total;
	}
	
	//购物车的功能：
	//1.将购物项添加到购物车
	public void addCart(ShoppingCartItem cartItem) {
		//判断购物车中是否已经存在该购物项;
		/**
		 * 若存在：数量增加
		 * 总计 += 购物项小计
		 * 
		 * 若不存在:
		 * 向map中添加购物项
		 * 总计 += 购物项小计
		 */
		//获得商品productId
		Integer productId = cartItem.getProduct().getProductId();
		//判断购物车中是否已经存在该购物项
		if(map.containsKey(productId)){
			//存在，获得购物车中原来的购物项
			ShoppingCartItem _carCartItem = map.get(productId);
			//原来的购物项的数量加上现在的购物项数量
			_carCartItem.setCount(_carCartItem.getCount()+cartItem.getCount());
		}else {
			map.put(productId, cartItem);
		}
		// 设置总计的值
		total += cartItem.getSubtotal();
	}
	
	// 2.从购物车移除购物项
	public void removeCart(Integer productId) {
		//将购物项移除购物车
		ShoppingCartItem cartItem = map.remove(productId);
		total -= cartItem.getSubtotal();
	}
	
	//3.清空购物车
	public void clearCart() {
		//将所有购物项清空
		map.clear();
		//将总计设置为0
		total = 0;
	}
}
