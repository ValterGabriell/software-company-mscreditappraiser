package io.github.valtergabriell.mslogin.infra.RabbitMQ;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.create-card}")
    private String queue;

    @Bean
    public Queue queueCreateCard(){
        return new Queue(queue, true);
    }
}
