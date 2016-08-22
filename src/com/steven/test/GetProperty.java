package com.steven.test;

public class GetProperty {
	public static String getPropertyByName(String path, String name) {
		String result = "";

		try {
			// 方法一：通过java.util.ResourceBundle读取资源属性文件
			result = java.util.ResourceBundle.getBundle(path).getString(name);
			System.out.println("name:" + result);
		} catch (Exception e) {
			System.out.println("getPropertyByName2 error:" + name);
		}
		return result;
	}
}
