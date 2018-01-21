package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.memento.Original;
import com.xiang.demo.java.designpattern.behaviormodel.memento.Storage;

/**
 * 备忘录模式测试类
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 下午1:19:55
 */
public class MementoTest {

	@Test
	public void test() {
		//创建原始类
		Original origi = new Original("egg");
		
		//创建备忘录
		Storage storage = new Storage(origi.createMemento());
		
		//修改原始类的状态
		System.out.println("初始化状态为: " + origi.getValue());
		origi.setValue("new");
		System.out.println("修改后的状态: " + origi.getValue());
		
		//回复原始类的状态
		origi.restoreMemento(storage.getMemento());
		System.out.println("恢复后的状态为: " + origi.getValue());
	}
	
}
