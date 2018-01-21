package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.structuremodel.adapter.Adapter;
import com.xiang.demo.java.designpattern.structuremodel.adapter.Source;
import com.xiang.demo.java.designpattern.structuremodel.adapter.SourceSub1;
import com.xiang.demo.java.designpattern.structuremodel.adapter.SourceSub2;
import com.xiang.demo.java.designpattern.structuremodel.adapter.Sourceable;
import com.xiang.demo.java.designpattern.structuremodel.adapter.Targetable;
import com.xiang.demo.java.designpattern.structuremodel.adapter.Wrapper;

/**
 * @ClassNmae AdapterTest
 * @Description Adapter类继承Source类，实现Targetable接口<p>
 * @author hairui
 * @Date 2017年4月25日 下午3:29:00
 */
public class AdapterTest {

	/**
	 * 类的适配器模式
	 */
	@Test
	public void testClassAdapter() {
		
		Targetable target = new Adapter();
		target.method1();
		target.method2();
		
	}
	
	/**
	 * 对象的适配器模式
	 */
	@Test
	public void testWrapper() {
		
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
		
	}
	
	/**
	 * 接口的适配器模式
	 */
	@Test
	public void testWrapper2() {
		
		Sourceable source1 = new SourceSub1();
		Sourceable source2 = new SourceSub2();
		
		source1.method1();
		source1.method2();
		source2.method1();
		source2.method2();
		
	}
	
	
}
