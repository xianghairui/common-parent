package com.xiang.demo.java.designpattern.structuremodel.adapter;

/**
 * @ClassNmae Wrapper
 * @Description 对象的适配器模式<p>
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，
 * 这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题。
 * @author xianghairui@outlook.com
 * @Date 2017年5月2日 上午11:11:52
 */
public class Wrapper implements Targetable{
	
	private Source source;
	
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	
	@Override
	public void method1() {
		source.method1();
	}

	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

}
