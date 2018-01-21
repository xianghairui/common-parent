package com.xiang.demo.java.designpattern.behaviormodel.strategy;

/**
 * @ClassNmae Multiply
 * @Description 乘<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月9日 上午10:43:48
 */
public class Multiply extends AbstractCalculator implements ICalculator {

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "\\*");
		return arrayInt[0] * arrayInt[1];
	}

}
