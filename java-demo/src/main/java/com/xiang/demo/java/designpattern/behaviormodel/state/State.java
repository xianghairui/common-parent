package com.xiang.demo.java.designpattern.behaviormodel.state;

/**
 * 状态类的核心类
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 下午1:23:08
 */
public class State {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void method1() {
		System.out.println("execute the first opt!");
	}
	
	public void method2() {
		System.out.println("execute the secound opt!");
	}
	
}
