package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.structuremodel.bridge.Bridge;
import com.xiang.demo.java.designpattern.structuremodel.bridge.MyBridge;
import com.xiang.demo.java.designpattern.structuremodel.bridge.SourceSub1;
import com.xiang.demo.java.designpattern.structuremodel.bridge.SourceSub2;
import com.xiang.demo.java.designpattern.structuremodel.bridge.Sourceable;

/**
 * @ClassNmae BridgeTest
 * @Description 桥接模式测试类<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月2日 下午2:39:45
 */
public class BridgeTest {
	
	@Test
	public void testBridge() {
		
		Bridge bridge = new MyBridge();
		
		/* 调用第一个对象 */
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		
		/* 调用第二个对象 */
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
		
		
	}
	
}
