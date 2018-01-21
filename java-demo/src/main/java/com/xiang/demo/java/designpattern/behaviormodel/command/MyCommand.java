package com.xiang.demo.java.designpattern.behaviormodel.command;

/**
 * @ClassNmae MyCommand
 * @Description MyCommand是命令，实现了Command接口，持有接收对象<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 上午10:47:48
 */
public class MyCommand implements Command {

	private Receiver receiver;
	
	public MyCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void exe() {
		receiver.action();
	}

}
