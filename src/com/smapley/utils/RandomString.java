package com.smapley.utils;

import java.util.Random;

public class RandomString {

	private static int length = 20;

	/**
	 * 随机生成字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString() {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
