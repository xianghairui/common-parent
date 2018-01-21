package com.xiang.demo.reids.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author xianghairui@outlook.com
 * @Date 2017年5月30日 下午10:26:14
 */
public class TestRedis {

	@Test
	public void test01() {
		String ip = "192.168.231.140";
		
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis(ip, 6379);
        jedis.auth("123456");   // 设置密码
        System.out.println("Connection to server sucessfully");
        // 设置 redis 字符串数据
        jedis.set("redis", "Redis 1");
        // 获取存储的数据并输出
        System.out.println("redis : " + jedis.get("redis"));


	}

}
