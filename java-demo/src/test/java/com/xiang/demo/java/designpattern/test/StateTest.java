package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.state.Context;
import com.xiang.demo.java.designpattern.behaviormodel.state.State;

/**
 * 状态模式测试<p>
 * 核心思想就是：当对象的状态改变时，同时改变其行为
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 下午1:31:35
 */
public class StateTest {
	
	@Test
	public void test() {
		
		State state = new State();
		Context context = new Context(state);
		
		//设置第一种状态
		state.setValue("state1");
		context.method();
		
		//设置第二种状态
		state.setValue("state2");
		context.method();
		
	}
	
}
