package com.epam.techtalk.spring.integration.planet.express.app.basic.crew;

import com.epam.techtalk.spring.integration.planet.express.common.Order;
import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;
import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import java.util.Collection;

import static com.epam.techtalk.spring.integration.planet.express.common.MessagePreparer.prepare;

/**
 * Professor bean.
 * Professor gets order and split into the items.
 */
@MessageEndpoint
public class Professor {
    @Splitter(inputChannel = QueueNames.INPUT_QUEUE, outputChannel = QueueNames.HERMES_QUEUE)
    public Collection<OrderItem> process(Order order) throws Exception {
        System.out.println(prepare(0, "Professor started ... "));
        Thread.sleep(3000);
        System.out.println(prepare(0, "Processor ... done"));
        return order.getItems();
    }
}
