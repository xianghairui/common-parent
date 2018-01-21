package com.xiang.demo.java.designpattern.test;

import java.text.StringCharacterIterator;

import org.junit.Test;

import com.xiang.demo.java.designpattern.behaviormodel.interpreter.Context;
import com.xiang.demo.java.designpattern.behaviormodel.interpreter.Minus;
import com.xiang.demo.java.designpattern.behaviormodel.interpreter.Plus;

public class InterpreterTest {

	@Test
	public void test() {
		String hellp = new String("kkdd");
		//计算9+2-8得值
		int result = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));
		System.out.println(result);
		
	}
	
}
