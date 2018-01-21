package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.structuremodel.proxy.Proxy;
import com.xiang.demo.java.designpattern.structuremodel.proxy.Sourceable;

public class ProxyTest {
	
	@Test
	public void testProxy(){
		Sourceable source = new Proxy();
		source.method();
	}
	
}
