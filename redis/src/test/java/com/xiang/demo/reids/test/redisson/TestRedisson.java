package com.xiang.demo.reids.test.redisson;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class TestRedisson {
	
	@Test
	public void test01() {
		Config config = new Config();
		config.setUseLinuxNativeEpoll(true);
		//可以用"rediss://"来启用SSL连接
		config.useClusterServers().addNodeAddress("redis://127.0.0.1:6379");
		RedissonClient redisson = Redisson.create(config);
		System.out.println(redisson.getKeys());
	}
	
}
