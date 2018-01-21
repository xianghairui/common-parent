package com.xiang.demo.java.designpattern.createmodel.factory;

/**
 * @ClassName SendFactory3 
 * @Description 静态工厂方法
 * 将多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
 * @author hairui
 * @date 2017年4月17日 下午6:07:20 
 *
 */
public class SendFactory3 {
	
	public static Sender produceMail() {
		return new MailSender();
	}
	
	public static Sender produceSms() {
		return new SmsSender();
	}
	
}
