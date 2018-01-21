package com.xiang.demo.memcached.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.spy.memcached.MemcachedClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class MemcachedClientTest {
	
	@Autowired
	private MemcachedClient memcachedClient;
	
	@Test
	public void test() throws InterruptedException, ExecutionException {
		System.out.println("Connection to server successful.");

		// 存储数据
		Future<Boolean> fo = memcachedClient.set("runoob", 900, "Free Education");

		// 查看储存状态
		System.out.println("set status:" + fo.get());

		// 输出值
		System.out.println("runboo value in cache - " + memcachedClient.get("runoob"));

		// 添加
		Future<Boolean> foAdd = memcachedClient.add("add", 900, "add memcached");

		// 打印状态
		System.out.println("add status: " + foAdd.get());

		// 添加新key
		foAdd = memcachedClient.add("codingground", 900, "All Free Compilers");

		// 打印装填
		System.out.println("add new status: " + fo.get());

		// 输出
		System.out.println("codingground value in cache - " + memcachedClient.get("codingground"));

		for (int i = 1; i < 10; i++) {
			memcachedClient.set("T0001" + i, 3600, new User(i + "", "小明" + i, i, "男", "住址： " + i, "test" + i + "@qq.com", null));
		}
		User myObject = (User) memcachedClient.get("T00011");
		System.out.println("Get object from mem :" + myObject);
	}
	
}
