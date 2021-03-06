package com.xiang.demo.java.designpattern.behaviormodel.strategy;

/**
 * @ClassNmae Plus
 * @Description 加<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月9日 上午10:44:29
 */
public class Plus extends AbstractCalculator implements ICalculator{

	@Override
	public int calculate(String exp) {
		int arrayInt[] = split(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}

}
