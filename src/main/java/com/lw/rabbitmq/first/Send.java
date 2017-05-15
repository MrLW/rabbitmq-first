package com.lw.rabbitmq.first;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	// 队列名称
	private final static String QUEUE_NAME = "queue"; 
	
	public static void main(String[] args) throws Exception {
		// 创建连接MabbitMQ工厂
		ConnectionFactory factory = new ConnectionFactory();
		// 设置MabbitMQ所在主机IP或者主机名
		factory.setHost("127.0.0.1");
		// 创建一个连接
		Connection connection = factory.newConnection();
		// 创建一个频道
		Channel channel = connection.createChannel();
		// 指定队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "hello mq"; 
		// 向队列中发送消息
		channel.basicPublish("", QUEUE_NAME, null,message.getBytes());
		System.out.println("发送的消息：" + message );
		// 关闭资源
		channel.close();
		connection.close();
	}
}
