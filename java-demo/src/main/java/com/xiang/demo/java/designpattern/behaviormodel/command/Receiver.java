package com.xiang.demo.java.designpattern.behaviormodel.command;

/**
 * @ClassNmae Receiver
 * @Description Receiver是被调用者（士兵）<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 上午10:46:33
 */
public class Receiver {
	
	public void action() {
		System.out.println("command received!");
	}
	
}
