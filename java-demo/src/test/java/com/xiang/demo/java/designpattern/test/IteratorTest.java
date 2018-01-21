package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.iterator.Collection;
import com.xiang.demo.java.designpattern.behaviormodel.iterator.Iterator;
import com.xiang.demo.java.designpattern.behaviormodel.iterator.MyCollection;

public class IteratorTest {
	
	@Test
	public void test() {
		Collection collection = new MyCollection();
		Iterator it = collection.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
}
