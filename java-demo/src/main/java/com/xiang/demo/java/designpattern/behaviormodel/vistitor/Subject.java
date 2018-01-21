package com.xiang.demo.java.designpattern.behaviormodel.vistitor;

public interface Subject{

	/**
	 * accept方法，接受将要访问它的对象
	 * @param visitor
	 */
	public void accept(Visitor visitor);
	
	/**
	 * getSubject()获取将要被访问的属性
	 * @return
	 */
	public String getSubject();
	
}
