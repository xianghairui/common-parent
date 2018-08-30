package com.xiang.demo.java.thread.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Auther: xianghairui
 * Date: 2018/6/15 15:08
 * Description:
 */
public class TestThreadLocal {

    private static final Logger logger = LoggerFactory.getLogger(TestThreadLocal.class);

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());

        logger.info("longThreadLocal={}", this.getLong());
        logger.info("stringThreadLocal={}", this.getString());
    }

    public Long getLong() {
        return longThreadLocal.get();
    }

    public String getString() {
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final TestThreadLocal test = new TestThreadLocal();
        test.set();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                test.set();
            }
        };
        thread1.start();
        thread1.join();


        logger.info("longThreadLocal={}", test.getLong());
        logger.info("stringThreadLocal={}", test.getString());
    }


}
