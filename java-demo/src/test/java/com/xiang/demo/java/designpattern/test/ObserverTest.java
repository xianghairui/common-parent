package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.observer.MySubject;
import com.xiang.demo.java.designpattern.behaviormodel.observer.Observer1;
import com.xiang.demo.java.designpattern.behaviormodel.observer.Observer2;
import com.xiang.demo.java.designpattern.behaviormodel.observer.Subject;

/**
 * 观察者模式
 * @ClassNmae ObserverTest
 * @Description TODO<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月9日 下午6:25:12
 */
public class ObserverTest {

	@Test
	public void test() {
		Subject sub = new MySubject();
		sub.add(new Observer1());
		sub.add(new Observer2());
		
		sub.operation();
	}
	
}
