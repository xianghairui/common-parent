package com.xiang.demo.java.designpattern.createmodel.factory;

/**
 * @ClassName SendFactory 
 * @Description 多个工厂方法模式<p>
 * 是对普通工厂模式的改进，在普通工厂方法模式中，
 * 如果传递的字符串出错，则不能正确创建对象，
 * 而多个工厂方法模式是提供多个工厂方法，分别创建对象。
 * @author hairui
 * @date 2017年4月17日 下午5:53:16 
 *
 */
public class SendFactory2 {

	public Sender produceMail() {
		return new MailSender();
	}
	
	public Sender produceSms() {
		return new SmsSender();
	}
	
}
