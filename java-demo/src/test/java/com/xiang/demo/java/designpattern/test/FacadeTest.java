package com.xiang.demo.java.designpattern.test;

import org.junit.Test;

import com.xiang.demo.java.designpattern.structuremodel.facade.Computer;

/**
 * @ClassNmae FacadeTest
 * @Description 外观模式<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月2日 下午2:22:17
 */
public class FacadeTest {
	
	@Test
	public void testComputer() {
		Computer computer = new Computer();
		computer.startup();
		computer.shutdown();
	}
	
}
