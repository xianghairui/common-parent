package com.xiang.demo.java.designpattern.behaviormodel.observer;

/**
 * @ClassNmae Observer1
 * @Description 观察者1<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月9日 下午1:59:37
 */
public class Observer1 implements Observer {

	@Override
	public void update() {
		System.out.println("observer1 has received!");
	}

}
