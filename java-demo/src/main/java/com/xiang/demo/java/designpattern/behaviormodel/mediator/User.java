package com.xiang.demo.java.designpattern.behaviormodel.mediator;

public abstract class User {
	
	private Mediator mediator;

	public User(Mediator mediator) {
		this.mediator = mediator;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public abstract void work();
	
}
