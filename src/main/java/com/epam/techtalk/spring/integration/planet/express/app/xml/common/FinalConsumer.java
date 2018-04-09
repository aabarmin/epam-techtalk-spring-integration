package com.epam.techtalk.spring.integration.planet.express.app.xml.common;

import com.epam.techtalk.spring.integration.planet.express.common.Delivery;

/**
 * Final consumer of delivery items.
 */
public class FinalConsumer {
    public void consume(Delivery delivery) {
        System.out.println("Delivery was processed");
    }
}
