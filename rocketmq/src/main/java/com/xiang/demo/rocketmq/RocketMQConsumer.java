package com.xiang.demo.rocketmq;

import java.util.UUID;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

/**
 * MQ消费
 * @author hairui
 *
 */
public class RocketMQConsumer {
	
	private DefaultMQPushConsumer consumer;
	
	private MessageListener listener;
	
	private String nameServer;
	
	private String groupName;
	
	protected String topics;

	public RocketMQConsumer(MessageListener listener, String nameServer, String groupName, String topics) {
		super();
		this.listener = listener;
		this.nameServer = nameServer;
		this.groupName = groupName;
		this.topics = topics;
	}
	
	public void init() {
		consumer = new DefaultMQPushConsumer(groupName);
		consumer.setNamesrvAddr(nameServer);
		try {
			consumer.subscribe(topics, "*");
		} catch (MQClientException e) {
			e.printStackTrace();
		}
		
		consumer.setInstanceName(UUID.randomUUID().toString());
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
		consumer.registerMessageListener(this.listener);
		
		try {
			consumer.start();
		} catch (MQClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RocketMQConsumer Started! group=" + 
				consumer.getConsumerGroup() + " instance=" + consumer.getInstanceName());  
	}
	
}
