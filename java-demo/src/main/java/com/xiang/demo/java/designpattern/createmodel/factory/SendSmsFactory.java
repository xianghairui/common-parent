package com.xiang.demo.java.designpattern.createmodel.factory;

/**
 * @ClassName SendSmsFactory
 * @Description 抽象工厂模式-短信工厂方法
 * @author hairui
 * @date 2017年4月17日 下午6:17:44
 *
 */
public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
