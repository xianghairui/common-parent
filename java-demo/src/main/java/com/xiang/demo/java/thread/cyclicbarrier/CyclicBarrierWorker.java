package com.xiang.demo.java.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierWorker implements Runnable {

	private int id;
	
	private CyclicBarrier barrier;
	
	public CyclicBarrierWorker(int id, final CyclicBarrier barrier){
		this.id = id;
		this.barrier = barrier;
	}
	
	
	@Override
	public void run() {
		
		System.out.println(id + " th people wait!");
		try {
			barrier.await(); // 大家等待最后一个线程到达
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		
	}

}
