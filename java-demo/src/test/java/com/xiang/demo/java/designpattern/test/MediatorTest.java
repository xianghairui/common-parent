package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.mediator.Mediator;
import com.xiang.demo.java.designpattern.behaviormodel.mediator.MyMediator;

public class MediatorTest {
	
	@Test
	public void test() {
		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
	
}
