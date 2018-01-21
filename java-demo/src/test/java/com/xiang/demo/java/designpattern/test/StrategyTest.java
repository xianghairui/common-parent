package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.strategy.ICalculator;
import com.xiang.demo.java.designpattern.behaviormodel.strategy.Minus;
import com.xiang.demo.java.designpattern.behaviormodel.strategy.Plus;

/**
 * @ClassNmae StrategyTest
 * @Description 策略模式<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月9日 上午10:43:04
 */
public class StrategyTest {

	@Test
	public void testPlus(){
		String exp = "2+8";
		ICalculator cal = new Plus();
		int reuslt = cal.calculate(exp);
		System.out.println(reuslt);
	}
	
	@Test
	public void testMinus(){
		String exp = "2-8";
		ICalculator cal = new Minus();
		int reuslt = cal.calculate(exp);
		System.out.println(reuslt);
	}
	
}
