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
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Configuration
public class RabbitMQConfig {

	public static final String topicExchangeName = "springregion-excange";
	public static final String queueName = "rabbit-queue";
	public static final String messageTopic = "springregion.#";

	// Health check UP when not active
	@ConditionalOnProperty(value = "rabbitmq.active", havingValue = "false")
	@Bean
	public HealthIndicator rabbitHealthIndicator() {
		return () -> Health.up().withDetail("version", "mock").build();
	}

	@ConditionalOnProperty(value = "rabbitmq.active")
	@Bean
	public Queue queue() {
		return new Queue(queueName, false);
	}

	@ConditionalOnProperty(value = "rabbitmq.active")
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@ConditionalOnProperty(value = "rabbitmq.active")
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(messageTopic);
	}

	@ConditionalOnProperty(value = "rabbitmq.active")
	@Bean
	public SimpleMessageListenerContainer listenGlobalMessage(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@ConditionalOnProperty(value = "rabbitmq.active")
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