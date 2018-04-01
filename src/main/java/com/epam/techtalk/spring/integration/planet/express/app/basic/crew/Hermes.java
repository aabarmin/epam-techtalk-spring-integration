package com.epam.techtalk.spring.integration.planet.express.app.basic.crew;

import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;
import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Router;

import static com.epam.techtalk.spring.integration.planet.express.common.MessagePreparer.prepare;

/**
 * Hermes is a router.
 */
@MessageEndpoint
public class Hermes {
    @Router(inputChannel = QueueNames.HERMES_QUEUE, poller = @Poller(fixedRate = "2000"))
    public String route(OrderItem orderItem) {
        System.out.println(prepare(1, "Hermes started ..."));
        try {
            switch (orderItem.getActionType()) {
                case CUT: return QueueNames.ZOIDBERG_QUEUE;
                case BEND: return QueueNames.BENDER_QUEUE;
            }
        } finally {
            System.out.println(prepare(1, "Hermes ... done"));
        }
        throw new IllegalArgumentException("Unsupported order item type");
    }
}
