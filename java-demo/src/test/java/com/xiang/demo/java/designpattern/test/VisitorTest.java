package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.vistitor.MySubject;
import com.xiang.demo.java.designpattern.behaviormodel.vistitor.MyVisitor;
import com.xiang.demo.java.designpattern.behaviormodel.vistitor.Subject;
import com.xiang.demo.java.designpattern.behaviormodel.vistitor.Visitor;

/**
 * 访问者模式
 * 访问者模式就是一种分离对象数据结构与行为的方法，通过这种分离，可达到为一个被访问者动态添加新的操作而无需做其它的修改的效果。
 * @author xianghairui@outlook.com
 * @Date 2017年5月10日 下午2:33:44
 */
public class VisitorTest {

	@Test
	public void test() {
		
		Visitor visitor = new MyVisitor();
		Subject sub = new MySubject();
		
		sub.accept(visitor);
	}
	
}
