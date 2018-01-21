package com.xiang.demo.java.designpattern.behaviormodel.observer;

import java.util.Enumeration;
import java.util.Vector;

public class AbstractSubject implements Subject {

	private Vector<Observer> vector = new Vector<Observer>();
	
	@Override
	public void add(Observer observer) {
		vector.add(observer);
	}

	@Override
	public void del(Observer observer) {
		vector.remove(observer);
	}

	@Override
	public void notifyObservers() {
		Enumeration<Observer> enume = vector.elements();
		while(enume.hasMoreElements()) {
			enume.nextElement().update();
		}
	}

	@Override
	public void operation() {
		
	}

}
