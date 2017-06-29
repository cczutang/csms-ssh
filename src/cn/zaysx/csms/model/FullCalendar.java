package cn.zaysx.csms.model;

/**
 * 日历对应订单金额封装类
 * @author tangyajun
 *
 */
public class FullCalendar {
	
	//订单个数
	private Integer count;
	
	//当前项金额
	private String titile;
	//开始时间
	private String start;
	
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

}
