package com.smapley.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyData {

	public static final String SUCC = "succeed";
	public static final String NOTNEW = "NotNew";
	public static final String ISNEW = "IsNew";
	public static final String FAIL = "fail";
	public static final String OutLogin = "OutLogin";
	public static final String ERR = "程序错误！";
	public static final String ERR_USERNAME = "用户名已存在！";
	public static final String ERR_USERNAME2 = "用户名不存在！";
	public static final String ERR_PASSWORD = "密码不正确！";
	public static final String ERR_UpLoadFail = "上传失败！";
	public static final String ERR_NoUser = "用户不存在！";
	public static final String ERR_OutLogin = "用户已在其他客户端登陆，请重新登陆！";
	public static final String ERR_ProjectName = "项目名已存在！";

	public static ApplicationContext cxt;

	public static ApplicationContext getCXT() {
		if (cxt == null)
			cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
		return cxt;
	}
}
