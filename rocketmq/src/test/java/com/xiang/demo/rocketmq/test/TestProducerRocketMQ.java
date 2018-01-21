package com.xiang.demo.rocketmq.test;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class TestProducerRocketMQ {
	
	private static final String ROCKETMQ_URL = "192.168.1.101:9876";
	
	public static void main(String[] args) throws MQClientException {
		DefaultMQProducer producer = new DefaultMQProducer("producerGroupName");
		producer.setNamesrvAddr(ROCKETMQ_URL);
		producer.start();
		try {
			{
				// topic:主题 testTopic.tags:主题下的tag tagA.keys:keyA.body:具体业务消息体
				Message msg = new Message("testTopic", "tagA", "keyA", ("Hello World tagA!").getBytes());
				for (int i = 100; i > 0; i--) {
					if (i % 2 == 0) {
						SendResult sendResult = producer.send(msg);
						Thread.sleep(1000);
						System.out.println("tagA send result：" + sendResult);
					} else {
						msg = new Message("testTopic", "tagB", "keyB", ("Hello World tagB!").getBytes());
						SendResult sendResult = producer.send(msg);
						Thread.sleep(1000);
						System.out.println("tagB send result:" + sendResult);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 注销producer
		Runtime.getRuntime().addShutdownHook(new Thread(() -> producer.shutdown()));
		System.exit(0);
	}
}
