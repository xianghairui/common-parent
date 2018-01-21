package com.xiang.demo.java.designpattern.createmodel.singleton;

import java.util.Vector;

/**
 * @ClassName Singleton4 
 * @Description 采用“影子实例”的办法为单例对象的属性同步更新
 * @author xianghairui@outlook.com
 * @date 2017年4月18日 下午11:30:30 
 *
 */
public class Singleton4 {
	
	private static Singleton4 instance = null;
	
	private Vector properties = null;
	
	public Vector getProperties() {
		return properties;
	}
	
	private Singleton4() {
		
	}
	
	private static synchronized void syncInit() {
		if(instance == null) {
			instance = new Singleton4();
		}
	}
	
	public static Singleton4 getInstance() {
		if(instance == null) {
			syncInit();
		}
		return instance;
	}
	
	public void updateProperties() {
		Singleton4 shadow = new Singleton4();
		properties = shadow.getProperties();
	}
	
}
