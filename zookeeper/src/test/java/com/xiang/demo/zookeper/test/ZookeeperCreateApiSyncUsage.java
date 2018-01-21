package com.xiang.demo.zookeper.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * 创建节点有异步和同步两种方式。无论是异步或者同步，Zookeeper都不支持递归调用，
 * 即无法在父节点不存在的情况下创建一个子节点，如在/zk-ephemeral节点不存在的情
 * 况下创建/zk-ephemeral/ch1节点；并且如果一个节点已经存在，那么创建同名节点
 * 时，会抛出NodeExistsException异常。
 * @author hairui
 *
 */
public class ZookeeperCreateApiSyncUsage implements Watcher {
	
	
	@Override
	public void process(WatchedEvent event) {
		// TODO Auto-generated method stub
		
	}

}
