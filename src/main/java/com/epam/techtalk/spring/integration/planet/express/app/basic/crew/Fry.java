package com.epam.techtalk.spring.integration.planet.express.app.basic.crew;

import com.epam.techtalk.spring.integration.planet.express.common.Delivery;
import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;
import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;

import java.util.Collection;

import static com.epam.techtalk.spring.integration.planet.express.common.MessagePreparer.prepare;

/**
 * Fry combines processed items to order back.
 */
@MessageEndpoint
public class Fry {
    @Aggregator(inputChannel = QueueNames.FRY_QUEUE, outputChannel = QueueNames.LEELA_QUEUE,
            poller = @Poller(fixedDelay = "5000"))
    public Delivery prepareDelivery(Collection<OrderItem> items) throws Exception {
        try {
            System.out.println(prepare(3, "Fry started ..."));
            Thread.sleep(4000);
            return new Delivery(items);
        } finally {
            System.out.println(prepare(3, "Fry ... done"));
        }
    }
}
