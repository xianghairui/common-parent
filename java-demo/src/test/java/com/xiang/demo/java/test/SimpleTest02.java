package com.xiang.demo.java.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author xianghairui@outlook.com
 * @Date 2017年6月20日 下午2:42:28
 */

public class SimpleTest02 {

	private static final Logger logger = LoggerFactory.getLogger(SimpleTest02.class);

	@Test
	public void test01() {
		byte b = 5;
		int i1 = 10;
		int i2 = 300;
		b = (byte) i1;
		System.out.println(b);
		b = (byte) i2;
		System.out.println(b);

	}

	@Test
	public void test02() {

	}

}
