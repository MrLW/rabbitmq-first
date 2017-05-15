package com.lw.rabbitmq.first;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

	// ��������
	private final static String QUEUE_NAME = "queue"; 
	
	public static void main(String[] args) throws Exception {
		// ��������MabbitMQ����
		ConnectionFactory factory = new ConnectionFactory();
		// ����MabbitMQ��������IP����������
		factory.setHost("127.0.0.1");
		// ����һ������
		Connection connection = factory.newConnection();
		// ����һ��Ƶ��
		Channel channel = connection.createChannel();
		// ָ������
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		String message = "hello mq"; 
		// ������з�����Ϣ
		channel.basicPublish("", QUEUE_NAME, null,message.getBytes());
		System.out.println("���͵���Ϣ��" + message );
		// �ر���Դ
		channel.close();
		connection.close();
	}
}
