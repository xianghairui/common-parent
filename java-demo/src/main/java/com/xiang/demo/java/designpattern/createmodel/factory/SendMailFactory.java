package com.xiang.demo.java.designpattern.createmodel.factory;

/**
 * @ClassName SendMailFactory
 * @Description 抽象工厂模式-邮件工厂方法
 * @author hairui
 * @date 2017年4月17日 下午6:18:21
 *
 */
public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
