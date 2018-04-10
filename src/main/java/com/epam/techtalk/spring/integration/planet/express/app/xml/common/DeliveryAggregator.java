package com.epam.techtalk.spring.integration.planet.express.app.xml.common;

import com.epam.techtalk.spring.integration.planet.express.common.Delivery;
import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;

import java.util.Collection;

/**
 * Aggregates processed order items into delivery item.
 */
public class DeliveryAggregator {
    public Delivery aggregate(Collection<OrderItem> items) {
        return new Delivery(items);
    }
}
