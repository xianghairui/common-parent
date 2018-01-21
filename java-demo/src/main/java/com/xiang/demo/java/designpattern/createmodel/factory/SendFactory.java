package com.xiang.demo.java.designpattern.createmodel.factory;

/**
 * @ClassName SendFactory
 * @Description 普通工厂方法
 * @author hairui
 * @date 2017年4月17日 下午6:03:44
 *
 */
public class SendFactory {
	
	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("请输入正确的类型!");
			return null;
		}
	}
	
}
