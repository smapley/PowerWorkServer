package com.smapley.utils;



public class Code {

	
	public static String enCode(String data,String code){
		String result="";
		byte[] bytes1=data.getBytes();
		byte[] bytes2=code.getBytes();
		for (int i = 0; i < bytes1.length; i++) {
			bytes1[i]+=bytes2[i];
			result+=bytes1[i]+",";
		}
		return result;
	}
	
	public static String doCode(String data,String code){
		String[] datas=data.split(",");
		byte[] bytes1=new byte[datas.length];
		byte[] bytes2=code.getBytes();
		for (int i = 0; i < bytes1.length; i++) {
			bytes1[i]=(byte) (Integer.parseInt(datas[i])-bytes2[i]);
		}
		return new String(bytes1);
	}
	
}
