package com.xiang.demo.java.thread.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Java通过Executors提供四种线程池，分别为：
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。 newScheduledThreadPool
 * 创建一个定长线程池，支持定时及周期性任务执行。 newSingleThreadExecutor
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 * 
 * @author xianghairui@outlook.com
 * @Date 2017年5月30日 下午3:50:32
 */
public class TestThreadPool {

	private static Logger logger = LoggerFactory.getLogger(TestThreadPool.class);

	/**
	 * newCachedThreadPool 创建一个可缓存线程池，如果线程池长度超过处理需要， 可灵活回收空闲线程，若无可回收，则新建线程。
	 */
	@Test
	public void testCacheThreadPool() {
		ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cacheThreadPool.execute(new Runnable() {

				@Override
				public void run() {
					logger.info(index + "");
				}

			});
		}
	}

	/**
	 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
	 */
	@Test
	public void testFixThreadPool() {

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						logger.info(index + "");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		fixedThreadPool.shutdown();
		while (true) {
			try {
				if(fixedThreadPool.isTerminated()){
					logger.info("任务执行结束！");
					break;
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
	 */
	@Test
	public void testScheduledThreadPool() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			@Override
			public void run() {
				logger.info("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);
		//scheduledThreadPool.shutdown();
//		while (true) {
//			try {
//				if(scheduledThreadPool.isTerminated()){
//					logger.info("任务执行结束！");
//					break;
//				}
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

	@Test
	public void testScheduledThreadPool2() {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		//scheduleAtFixedRate创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 
		//后开始执行，然后在 initialDelay+period 后执行，接着在 initialDelay + 2 * period 后执行，依此类推。
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("delay 1 seconds, and excute every 3 seconds");
			}
		}, 1, 3, TimeUnit.SECONDS);
		
//		scheduledThreadPool.shutdown();
//		while (true) {
//			try {
//				if(scheduledThreadPool.isTerminated()){
//					logger.info("任务执行结束！");
//					break;
//				}
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

	/**
	 * newSingleThreadExecutor
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
	 */
	@Test
	public void testSingleThreadExecutor() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 10; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						logger.info(index + "");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		singleThreadExecutor.shutdown();
		while(true) {
			try {
				if(singleThreadExecutor.isTerminated()){
					logger.info("任务完成！");
					break;
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
