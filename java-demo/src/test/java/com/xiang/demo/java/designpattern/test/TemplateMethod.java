package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.templatemethod.AbstractCalculator;
import com.xiang.demo.java.designpattern.behaviormodel.templatemethod.Plus;

/**
 * @ClassNmae TemplateMethod
 * @Description 模板模式<p>
 * 就是指：一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用，
 * @author xianghairui@outlook.com
 * @Date 2017年5月9日 下午1:07:53
 */
public class TemplateMethod {

	@Test
	public void test01(){
		String exp = "8+8";
		AbstractCalculator cal = new Plus();
		int result = cal.calculate(exp, "\\+");
	}
	
}
