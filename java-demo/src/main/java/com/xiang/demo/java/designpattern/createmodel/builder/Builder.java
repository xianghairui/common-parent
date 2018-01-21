package com.xiang.demo.java.designpattern.createmodel.builder;

import java.util.ArrayList;
import java.util.List;

import com.xiang.demo.java.designpattern.createmodel.factory.MailSender;
import com.xiang.demo.java.designpattern.createmodel.factory.Sender;
import com.xiang.demo.java.designpattern.createmodel.factory.SmsSender;

/**
 * @ClassNmae Builder
 * @Description 建造者模式<p>
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性，其实建造者模式就是前面抽象工厂模式和最后的Test结合起来得到的。我们看一下代码：
 * 还和前面一样，一个Sender接口，两个实现类MailSender和SmsSender
 * @author hairui
 * @Date 2017年4月24日 下午1:31:49
 */
public class Builder {

	private List<Sender> list = new ArrayList<Sender>();
	
	public void produceMailSender(int count) {
		for(int i = 0; i < count; i++){
			list.add(new MailSender());
		}
	}
	
	public void produceSmsSender(int count) {
		for(int i = 0; i < count; i++){
			list.add(new SmsSender());
		}
	}
	
}
