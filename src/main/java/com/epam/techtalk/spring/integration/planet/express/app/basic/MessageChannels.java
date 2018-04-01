package com.epam.techtalk.spring.integration.planet.express.app.basic;

import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;

/**
 * Channels configurations.
 */
@Configuration
public class MessageChannels {
    @Bean(name = QueueNames.HERMES_QUEUE)
    public MessageChannel hermesInputQueue() {
        return new QueueChannel(20);
    }

    @Bean(name = QueueNames.FRY_QUEUE)
    public MessageChannel fryInputQueue() {
        return new QueueChannel(20);
    }

    @Bean(name = QueueNames.ZOIDBERG_QUEUE)
    public MessageChannel zoidberInputQueue() {
        return new QueueChannel(20);
    }

    @Bean(name = QueueNames.BENDER_QUEUE)
    public MessageChannel benderInputQueue() {
        return new QueueChannel(20);
    }

    @Bean(name = QueueNames.LEELA_QUEUE)
    public MessageChannel leelaInputQueue() {
        return new QueueChannel(20);
    }

    @Bean(name = QueueNames.DELIVERY_QUEUE)
    public MessageChannel deliveryInputQueue() {
        return new QueueChannel(20);
    }
}
