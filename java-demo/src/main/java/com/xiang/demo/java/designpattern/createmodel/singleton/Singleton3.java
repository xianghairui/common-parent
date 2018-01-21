package com.xiang.demo.java.designpattern.createmodel.singleton;

/**
 * @ClassName SingletonTest 
 * @Description 单利模式创建 因为我们只需要在创建类的时候进行同步，所以只要将创建
 * 和getInstance()分开，单独为创建加synchronized关键字，也是可以的
 * @author xianghairui@outlook.com
 * @date 2017年4月17日 下午11:54:56 
 *
 */
public class Singleton3 {
	
	private static Singleton3 instance = null;
	
	private Singleton3() {
		
	}
	
	private static synchronized void syncInit() {
		if(instance == null) {
			instance = new Singleton3();
		}
	}
	
	public static Singleton3 getInstance() {
		if(instance == null) {
			syncInit();
		}
		return instance;
	}
	
}
