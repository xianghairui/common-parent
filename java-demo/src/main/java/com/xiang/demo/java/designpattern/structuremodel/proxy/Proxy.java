package com.xiang.demo.java.designpattern.structuremodel.proxy;

public class Proxy implements Sourceable {

	private Source source;
	
	public Proxy(){
		super();
		this.source = new Source();
	}
	
	private void after(){
		System.out.println("after proxy!");
	}
	
	private void before() {
		System.out.println("before proxy!");
	}
	
	@Override
	public void method() {
		before();
		source.method();
		after();
	}
	
	
	
}
