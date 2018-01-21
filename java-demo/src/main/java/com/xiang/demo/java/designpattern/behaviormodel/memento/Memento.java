package com.xiang.demo.java.designpattern.behaviormodel.memento;

/**
 * Memento类是备忘录类
 * @ClassNmae Memento
 * @Description TODO<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 下午1:14:11
 */
public class Memento {
	
	private String value;

	public Memento(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

	
}
