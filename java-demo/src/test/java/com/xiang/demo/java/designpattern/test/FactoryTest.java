package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.createmodel.factory.Provider;
import com.xiang.demo.java.designpattern.createmodel.factory.SendFactory;
import com.xiang.demo.java.designpattern.createmodel.factory.SendFactory2;
import com.xiang.demo.java.designpattern.createmodel.factory.SendFactory3;
import com.xiang.demo.java.designpattern.createmodel.factory.SendMailFactory;
import com.xiang.demo.java.designpattern.createmodel.factory.Sender;

/**
 * @ClassName FactoryTest
 * @Description 工厂模式适合：
 * 凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式
 * 进行创建。在以上的三种模式中，第一种如果传入的字符串有误，不能正确创建对
 * 象，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，我们会选
 * 用第三种——静态工厂方法模式。
 * @author hairui
 * @date 2017年4月17日 下午6:10:47
 *
 */
public class FactoryTest {

	@Test
	public void testSenderFactory() {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce("sms");
		sender.send();
	}

	@Test
	public void testSenderFactory2() {
		SendFactory2 factory = new SendFactory2();
		Sender sender = (Sender) factory.produceMail();
		sender.send();
	}

	@Test
	public void testSendFactory3() {
		Sender sender = SendFactory3.produceMail();
		sender.send();
	}
	
	/**
	 * 其实这个模式的好处就是，如果你现在想增加一个功能：发及时信息，
	 * 则只需做一个实现类，实现Sender接口，同时做一个工厂类，实现
	 * Provider接口，就OK了，无需去改动现成的代码。这样做，拓展性较好！
	 */
	@Test
	public void testProvider() {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
	}

}
