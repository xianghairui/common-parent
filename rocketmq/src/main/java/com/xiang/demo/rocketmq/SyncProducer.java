package com.xiang.demo.rocketmq;

import java.io.UnsupportedEncodingException;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class SyncProducer {
	
	public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, MQBrokerException, InterruptedException {
		DefaultMQProducer producer = new DefaultMQProducer("test_group");
		producer.setNamesrvAddr("192.168.1.101:9876");
		
		/*
		 * 在整个应用生命周期内，生产者需要调用一次start方法来初始化，初始化主要完成的任务有：
			如果没有指定namesrv地址，将会自动寻址
			启动定时任务：更新namesrv地址、从namsrv更新topic路由信息、清理已经挂掉的broker、向所有broker发送心跳...
			启动负载均衡的服务
		 */
		// 初始化Producer，整个应用生命周期内，只需要初始化1次
		producer.start();
		for(int i=0; i<100; i++) {
			Message msg = new Message("TopicTest" /* Topic */,
	                "TagA" /* Tag */,
	                ("Hello RocketMQ " +
	                    i).getBytes(RemotingHelper.DEFAULT_CHARSET) );
			
			// 构造Message
			Message msg2 = new Message("TopicTest1",// topic
			                        "TagA",// tag：给消息打标签,用于区分一类消息，可为null
			                        "OrderID188",// key：自定义Key，可以用于去重，可为null
			                        ("Hello MetaQ").getBytes());// body：消息内容
			// 发送消息并返回结果
			SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
		}
		
		//Shut down once the producer instance is not longer in use.
		//清理资源，关闭网络连接，注销自己
        producer.shutdown();
        
	}
	
}
