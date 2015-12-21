package com.smapley.db.modes;

import com.smapley.utils.MyData;

public class Result {

	
	public String flag = MyData.FAIL;
	public String details = MyData.ERR;
	public String data ;
	
	
	@Override
	public String toString() {
		return "Result [flag=" + flag + ", details=" + details + ", data="
				+ data + "]";
	}
}
