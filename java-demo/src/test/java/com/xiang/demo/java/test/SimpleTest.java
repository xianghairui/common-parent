package com.xiang.demo.java.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SimpleTest {

	@Test
	public void test01() {
		/** 输出
		4
		1
		2
		3
		 */
		int type = 4;
		switch (type) {
		default:
			System.out.println(4);
		case 1:
			System.out.println(1);
		case 2:
			System.out.println(2);
		case 3:
			System.out.println(3);
		}
	}

	@SuppressWarnings("finally")
	@Test
	public void test02() throws Exception {
		try {
			throw new Exception("1");
		} catch (IOException e) {
			throw new Exception("2");
		} catch (Exception e) {
			throw new Exception("3");
		} finally {
			throw new Exception("4");//如果不抛出异常会在此行抛出异常
		}
	}
	
	@Test
	public void test03() {
		Boolean success = false;
		System.out.println((success == null) ? "" : "niik");
	}
	
	@Test
	public void test04() {
		
	}
	
	public static Map<String, Object> objectToMapAndNoClass(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				System.out.println(key);
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj.toString());
					String str = "key: " + key + " | value:" + value;
					System.out.println(str);
					map.put(key, value);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return map;
	}
	
	@Test
	public void test09(){
		double d = 1.000;
		for(int i=0;i<10;i++) {
			System.out.println(d+d);
		}
		
	}

}
