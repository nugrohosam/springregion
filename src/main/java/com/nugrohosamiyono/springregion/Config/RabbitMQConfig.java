package com.nugrohosamiyono.springregion.Config;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Configuration
public class RabbitMQConfig {

	public static final String topicExchangeName = "springregion-excange";
	public static final String queueName = "rabbit-queue";
	public static final String messageTopic = "springregion.#";

	@Bean
	public Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(messageTopic);
	}

	@Bean
	public SimpleMessageListenerContainer listenGlobalMessage(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "handleMessage");
	}
}

@Component
class Receiver {
	private CountDownLatch latch = new CountDownLatch(1);

	public void handleMessage(String message) {

		switch (message) {
		case "update-data-user":
			System.out.println("Updated data user");
			break;
		default:
			System.out.println("other message");
		}

		this.latch.countDown();
	}

	public CountDownLatch getLatch() {
		return this.latch;
	}
}