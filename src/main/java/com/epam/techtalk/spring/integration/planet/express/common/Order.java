package com.epam.techtalk.spring.integration.planet.express.common;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Order as a collection of order items.
 */
public class Order {
    private Collection<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Collection<OrderItem> items) {
        this.items = items;
    }

    /**
     * Getter for items.
     *
     * @return java.util.Collection<com.epam.techtalk.spring.integration.planet.express.common.OrderItem>
     */
    public Collection<OrderItem> getItems() {
        return items;
    }

    /**
     * Setter for items.
     *
     * @param items value
     */
    public void setItems(Collection<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
