package com.epam.techtalk.spring.integration.planet.express.app.xml.common;

import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;

/**
 * Set processed flag.
 */
public class ProcessingHandler {
    public OrderItem process(OrderItem item) {
        item.setProcessed(true);
        return item;
    }
}
