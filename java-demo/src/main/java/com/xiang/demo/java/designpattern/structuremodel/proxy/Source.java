package com.xiang.demo.java.designpattern.structuremodel.proxy;

public class Source implements Sourceable {

	@Override
	public void method() {
		System.out.println("the original method!");
	}

}
