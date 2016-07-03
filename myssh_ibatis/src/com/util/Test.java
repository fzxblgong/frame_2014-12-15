package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {
	public Test(){
		System.out.println("初始化："+Test.class.toString());
	}
	@org.junit.Test
	public void test() {
		String formatStr1 = "yyyy/MM/dd HH:mm";
		String formatStr2 = "yyyy-MM-dd";
		Object param = "2014-12-31";
		boolean flag = this.isValidDate(param.toString(),formatStr2);
		System.out.print(flag);
		
		/*if (param instanceof Integer) {
			int value = ((Integer) param).intValue();
		} else if (param instanceof String) {
			String s = (String) param;
		} else if (param instanceof Double) {
			double d = ((Double) param).doubleValue();
		} else if (param instanceof Float) {
			float f = ((Float) param).floatValue();
		} else if (param instanceof Long) {
			long l = ((Long) param).longValue();
		} else if (param instanceof Boolean) {
			boolean b = ((Boolean) param).booleanValue();
		} else if (param instanceof Date) {
			Date d = (Date) param;
		}*/
	}
	public boolean isValidDate(String str,String formatStr) {
	      boolean convertSuccess=true;
	       SimpleDateFormat format = new SimpleDateFormat(formatStr);
	       try {
	          format.setLenient(false);
	          format.parse(str);
	       } catch (ParseException e) {
	          // e.printStackTrace();
	// ���throw java.text.ParseException����NullPointerException����˵����ʽ����
	           convertSuccess=false;
	       } 
	       return convertSuccess;
	}
	//日期时间测试
	public void updateRoleId(){
		System.out.println("时间测试。。。");
	}
}
