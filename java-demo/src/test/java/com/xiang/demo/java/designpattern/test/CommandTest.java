package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.command.Command;
import com.xiang.demo.java.designpattern.behaviormodel.command.Invoker;
import com.xiang.demo.java.designpattern.behaviormodel.command.MyCommand;
import com.xiang.demo.java.designpattern.behaviormodel.command.Receiver;

/**
 * 命令模式（Command）
 * @ClassNmae CommandTest
 * @Description 
 * 命令模式很好理解，举个例子，司令员下令让士兵去干件事情，从整个事情的角度来考虑，司令员的作用是，发出口令，口令经过传递，传到了士兵耳朵里，士兵去执行。这个过程好在，三者相互解耦，任何一方都不用去依赖其他人，只需要做好自己的事儿就行，司令员要的是结果，不会去关注到底士兵是怎么实现的。<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 上午10:49:04
 */
public class CommandTest {

	/**
	 * 命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开，熟悉Struts的同学应该知道，Struts其实就是一种将请求和呈现分离的技术，其中必然涉及命令模式的思想！
	 */
	@Test
	public void test() {
		
		Receiver receiver = new Receiver();
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
		
		/*
		 * 
		 */
	}
	
}
