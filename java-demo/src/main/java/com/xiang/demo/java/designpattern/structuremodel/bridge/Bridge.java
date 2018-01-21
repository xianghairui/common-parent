package com.xiang.demo.java.designpattern.structuremodel.bridge;

/**
 * @ClassNmae Bridge
 * @Description 桥接模式<p>
 * 定义一个桥，持有Sourceable的实例
 * @author xianghairui@outlook.com
 * @Date 2017年5月2日 下午2:35:35
 */
public abstract class Bridge {
	
	private Sourceable source;
	
	public void method() {
		source.method();
	}
	
	public Sourceable getSource() {
		return source;
	}
	
	public void setSource(Sourceable source) {
		this.source = source;
	}
	
}
