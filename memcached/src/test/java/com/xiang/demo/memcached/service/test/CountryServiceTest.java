package com.xiang.demo.memcached.service.test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiang.demo.memcached.entity.Country;
import com.xiang.demo.memcached.service.CountryService;
import com.xiang.demo.memcached.util.CacheService;

import net.spy.memcached.MemcachedClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class CountryServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryServiceTest.class);
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CacheService cacheService;
	
	@Autowired
	private MemcachedClient memcachedClient;
	
	@Before
	public void init(){
		memcachedClient.delete("test");
		System.out.println("----- cache clear -----");
	}
	
	@Test
	public void test() {
		List<Country> list = countryService.query();
		System.out.println(list.toString());
	}
	
	@Test
	public void testQuery() {
		System.out.println(cacheService.query());
	}
	
	@Test
	public void testThread() throws InterruptedException {
		for(int i = 0; i < 1000; i++) {
			Thread t = new Thread(new ExecuteThread());
			t.start();
			latch.countDown();
		}
		Thread.currentThread();
		Thread.sleep(5000);
//		for(int i = 0; i < 3000; i++) {
//			Thread t = new Thread(new ExecuteThread());
//			t.start();
//			latch.countDown();
//		}
//		Thread.currentThread();
//		Thread.sleep(5000);
	}
	
	private CountDownLatch latch = new CountDownLatch(3000);
	
	private class ExecuteThread implements Runnable {

		@Override
		public void run() {
			latch.countDown();
			//List<Country> result = cacheService.query();
			List<Country> result = cacheService.queryTemplate();
			logger.info(result.toString());
		}

	}
	
}
