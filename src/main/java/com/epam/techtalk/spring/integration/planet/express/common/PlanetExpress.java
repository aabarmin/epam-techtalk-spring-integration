package com.epam.techtalk.spring.integration.planet.express.common;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Planet Express as is.
 */
@MessagingGateway
public interface PlanetExpress {
    @Gateway(requestChannel = QueueNames.INPUT_QUEUE)
    void placeOrder(Order order);
}
