package com.xiang.demo.java.designpattern.behaviormodel.interpreter;

/**
 * 加
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 下午5:07:47
 */
public class Plus implements Expression {

	@Override
	public int interpret(Context context) {
		return context.getNum1() + context.getNum2();
	}

}
