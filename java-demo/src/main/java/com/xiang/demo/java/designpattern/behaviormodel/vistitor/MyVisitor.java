package com.xiang.demo.java.designpattern.behaviormodel.vistitor;

public class MyVisitor implements Visitor {

	@Override
	public void visit(Subject sub) {
		System.out.println("visit this subject:" + sub.getSubject());
	}

}
