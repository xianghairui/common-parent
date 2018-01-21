package com.xiang.demo.memcached.test;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

public class MemcachedJavaTest {

	public static void main(String[] args) {

		try {
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("192.169.99.173", 11211));
			System.out.println("Connection to server successful.");

//			// 存储数据
//			Future fo = mcc.set("runoob", 900, "Free Education");
//
//			// 查看储存状态
//			System.out.println("set status:" + fo.get());
//
//			// 输出值
//			System.out.println("runboo value in cache - " + mcc.get("runoob"));
//
//			// 添加
			Future foAdd = mcc.add("add", -1, "add memcached");
//
//			// 打印状态
//			System.out.println("add status: " + foAdd.get());
//
//			// 添加新key
//			foAdd = mcc.add("codingground", 900, "All Free Compilers");
//
//			// 打印装填
//			System.out.println("add new status: " + fo.get());
//
//			// 输出
//			System.out.println("codingground value in cache - " + mcc.get("codingground"));
//
//			for (int i = 1; i < 10; i++) {
//				mcc.set("T0001" + i, 3600, new User(i + "", "小明" + i, i, "男", "住址： " + i, "test" + i + "@qq.com", null));
//			}
//			User myObject = (User) mcc.get("T00011");
//			System.out.println("Get object from mem :" + myObject);
			;

			// 关闭连接
			mcc.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
