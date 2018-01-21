package com.xiang.demo.java.designpattern.behaviormodel.memento;

/**
 * Storage类是存储备忘录的类，持有Memento类的实例
 * @author xianghairui@outlook.com
 * @ClassNmae Storage
 * @Description <p>
 * @Date 2017年5月10日 下午1:16:58
 */
public class Storage {

	private Memento memento;

	public Storage(Memento memento) {
		super();
		this.memento = memento;
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
	
}
