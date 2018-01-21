package com.xiang.demo.java.thread.simple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void test01() {

		ThreadTest t = new ThreadTest();
		for(int i=0; i<100;i++) {
			new Thread(t).start();			
		}

	}

}
