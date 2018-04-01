package com.epam.techtalk.spring.integration.planet.express.app.basic.crew;

import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;
import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;

import static com.epam.techtalk.spring.integration.planet.express.common.MessagePreparer.prepare;

/**
 * Zoidberg is a processor.
 */
@MessageEndpoint
public class Zoidberg {
    @ServiceActivator(inputChannel = QueueNames.ZOIDBERG_QUEUE, outputChannel = QueueNames
            .FRY_QUEUE, poller = @Poller(fixedRate = "3000"))
    public OrderItem process(OrderItem orderItem) throws Exception {
        try {
            System.out.println(prepare(2, "Zoidgber started ...."));
            Thread.sleep(25000);
            orderItem.setProcessed(true);
            return orderItem;
        } finally {
            System.out.println(prepare(2, "Zoidberg ... done"));
        }
    }
}
