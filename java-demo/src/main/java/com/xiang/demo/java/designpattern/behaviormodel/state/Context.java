package com.xiang.demo.java.designpattern.behaviormodel.state;

/**
 * 状态模式的切换类
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 下午1:25:31
 */
public class Context {
	
	private State state;

	public Context(State state) {
		super();
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void method() {
		if(state.getValue().equals("state1")){
			state.method1();
		} else if(state.getValue().equals("state2")) {
			state.method2();
		}
	}
	
	
	
}
