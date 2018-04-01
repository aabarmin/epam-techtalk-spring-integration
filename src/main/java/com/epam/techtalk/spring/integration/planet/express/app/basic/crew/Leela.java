package com.epam.techtalk.spring.integration.planet.express.app.basic.crew;

import com.epam.techtalk.spring.integration.planet.express.common.Delivery;
import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;

import static com.epam.techtalk.spring.integration.planet.express.common.MessagePreparer.prepare;

/**
 * Leels is a processor.
 */
@MessageEndpoint
public class Leela {
    @ServiceActivator(inputChannel = QueueNames.LEELA_QUEUE, outputChannel = QueueNames
            .DELIVERY_QUEUE, poller = @Poller(fixedRate = "1000"))
    public Delivery deliver(Delivery delivery) throws Exception {
        try {
            System.out.println(prepare(5, "Lella started ..."));
            return delivery;
        } finally {
            System.out.println(prepare(5, "Leela ... end"));
        }
    }
}
