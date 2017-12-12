package cn.ucai.weike.utils;

import org.springframework.stereotype.Repository;

public class Result {

	private Object retData;
	private boolean retMsg;
	private Integer retCode;
	public Object getRetData() {
		return retData;
	}
	public void setRetData(Object retData) {
		this.retData = retData;
	}
	public boolean isRetMsg() {
		return retMsg;
	}
	public void setRetMsg(boolean retMsg) {
		this.retMsg = retMsg;
	}
	public Integer getRetCode() {
		return retCode;
	}
	public void setRetCode(Integer retCode) {
		this.retCode = retCode;
	}
	@Override
	public String toString() {
		return "Result [retData=" + retData + ", retMsg=" + retMsg
				+ ", retCode=" + retCode + "]";
	}
	
	
	
}
