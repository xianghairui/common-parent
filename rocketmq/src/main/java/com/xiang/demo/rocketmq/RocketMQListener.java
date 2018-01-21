package com.xiang.demo.rocketmq;

import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * MQ消息的监听类
 * 
 * @author xianghairui@outlook.com
 * @Date 2017年8月23日 上午11:32:30
 */
public class RocketMQListener implements MessageListenerConcurrently {

	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		for (MessageExt message : msgs) {
			String msg = new String(message.getBody());
			System.out.println("msg data from rocketMQ:" + msg);
		}
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}
