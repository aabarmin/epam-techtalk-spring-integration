package com.epam.techtalk.spring.integration.planet.express.common;

import java.util.Collection;

/**
 * Delivery instance.
 */
public class Delivery extends Order {
    public Delivery(Collection<OrderItem> items) {
        super(items);
    }
}
