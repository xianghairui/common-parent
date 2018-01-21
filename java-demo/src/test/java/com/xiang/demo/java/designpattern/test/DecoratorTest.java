package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.structuremodel.decorator.Decorator;
import com.xiang.demo.java.designpattern.structuremodel.decorator.Source;
import com.xiang.demo.java.designpattern.structuremodel.decorator.Sourceable;

/**
 * @ClassNmae DecoratorTest
 * @Description 装饰模式测试类<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月2日 下午1:29:16
 */
public class DecoratorTest {

	@Test
	public void testDecorator() {
		
		Sourceable source = new Source();
		Sourceable obj = new Decorator(source);
		obj.method();
		
	}
	
}
