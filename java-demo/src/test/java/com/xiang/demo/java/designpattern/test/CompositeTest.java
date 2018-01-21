package com.xiang.demo.java.designpattern.test;

import com.xiang.demo.java.designpattern.structuremodel.composite.TreeNode;

/**
 * @ClassNmae CompositeTest
 * @Description 桥接模式测试<p>
 * @author xianghairui@outlook.com
 * @Date 2017年5月2日 下午4:26:46
 */
public class CompositeTest {
	
	TreeNode root = null;
	
	public CompositeTest(String name) {
		root = new TreeNode(name);
	}
	
	public static void main(String[] args) {
	
		CompositeTest tree = new CompositeTest("A");
		TreeNode nodeB = new TreeNode("B");
		TreeNode nodeC = new TreeNode("C");
		
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("build the tree finished!");
		
	}
	
}
