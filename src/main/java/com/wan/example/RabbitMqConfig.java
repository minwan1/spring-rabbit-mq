package com.wan.example;

import com.rabbitmq.client.AMQP;
import lombok.Setter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Setter
public class RabbitMqConfig {

    @Value("${myqueue}")
    private String queue;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Bean
    Queue queue(){ // rabitmq 등록
        return new Queue(queue, true);
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost",5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(rabbitConnectionFactory());
        container.setQueueNames(queue);
//        container.setMessageListener(exampleListener());
        container.setTransactionManager(platformTransactionManager);
        container.setChannelTransacted(true);
        return container;
    }

    @Bean
    public RabbitTemplate producerRabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory());
        rabbitTemplate.setQueue(queue);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.isChannelTransacted();
        rabbitTemplate.setChannelTransacted(true);
        rabbitTemplate.re
        return rabbitTemplate;
    }

    @Bean
    public MessageListener exampleListener() {
        return new MessageListener() {
            public void onMessage(Message message) {
                System.out.println("received: " + message);
            }
        };
    }
}
