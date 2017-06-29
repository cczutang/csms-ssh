package cn.zaysx.csms.model;

import com.github.abel533.echarts.Option;

public class WebResult {
	private Option data;
	private String msg;

	public Option getData() {
		return data;
	}

	public void setData(Option data) {
		this.data = data;
	}
	
	public boolean isOK(){
		if(getData()!=null&&!getData().equals("")){
			this.msg="加载成功";
			return true;
		}
		this.msg="加载失败";
		return false;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
