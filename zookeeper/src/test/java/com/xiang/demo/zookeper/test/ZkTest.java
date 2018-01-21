package com.xiang.demo.zookeper.test;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * zookeeper 测试基础类
 * @author xianghairui@outlook.com
 * @Date 2017年8月24日 下午6:06:06
 */
public class ZkTest {
	
	private static String connectString = "192.168.1.101:2181";
	private static int sessionTimeout = 999999;

	public static void main(String[] args) throws Exception {
		Watcher watcher = new Watcher() {
			public void process(WatchedEvent event) {
				System.out.println("监听到的事件：" + event);
			}
		};
		final ZooKeeper zookeeper = new ZooKeeper(connectString, sessionTimeout, watcher);
		System.out.println("获得连接：" + zookeeper);
			
		if(zookeeper.exists("/test", false) == null){
			zookeeper.create("/test", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		
		System.out.println("------- 查看节点是否安装成功 ----------");
		System.out.println(new String(zookeeper.getData("/test", false, null)));
		
		System.out.println("------ 修改节点数据 ------");
		String data = "zNode2";
		zookeeper.setData("/test", data.getBytes(), -1);
		
		System.out.println("------ 查看修改的节点是否成功 ------");
		System.out.println(new String(zookeeper.getData("/test", false, null)));
		
		System.out.println("------ 删除节点 ------");
		zookeeper.delete("/test", -1);
		
		System.out.println("------ 查看节点是否被删除 ------");
		System.out.println("节点状态：" + zookeeper.exists("/test", false));
		
		zookeeper.close();
		
	}
}
