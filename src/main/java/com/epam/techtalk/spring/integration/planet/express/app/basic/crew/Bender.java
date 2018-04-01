package com.epam.techtalk.spring.integration.planet.express.app.basic.crew;

import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;
import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;

import static com.epam.techtalk.spring.integration.planet.express.common.MessagePreparer.prepare;

/**
 * Bender is a processor.
 */
@MessageEndpoint
public class Bender {
    @ServiceActivator(inputChannel = QueueNames.BENDER_QUEUE, outputChannel = QueueNames
            .FRY_QUEUE, poller = @Poller(fixedRate = "3000"))
    public OrderItem process(OrderItem item) throws Exception {
        System.out.println(prepare(2, "Bender started ..."));
        try {
            Thread.sleep(2000);
            item.setProcessed(true);
            return item;
        } finally {
            System.out.println(prepare(2, "Bender ... end"));
        }
    }
}
