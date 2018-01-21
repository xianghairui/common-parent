package com.xiang.demo.java.thread.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadTest implements Runnable {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private int tickets = 200;

	@Override
	public void run() {
		while (true) {
			if (tickets > 0) {
				logger.error("afdsaf");
				logger.info("" + tickets--);
				//System.out.println(Thread.currentThread().getName() + " is saling ticket " + tickets--);
			}
		}
	}

}
