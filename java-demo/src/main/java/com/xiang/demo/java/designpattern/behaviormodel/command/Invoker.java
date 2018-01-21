package com.xiang.demo.java.designpattern.behaviormodel.command;

/**
 * 司令员
 * @ClassNmae 
 * @Description Invoker是调用者（司令员）<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 上午10:44:19
 */
public class Invoker {

	private Command command;
	
	public Invoker(Command comman) {
		this.command = comman;
	}
	
	public void action() {
		command.exe();
	}
	
}
