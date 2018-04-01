package com.epam.techtalk.spring.integration.planet.express.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class for producing orders.
 */
public class OrderProducer {
    public static Collection<Order> produce(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Order())
                .map(OrderProducer::withItems)
                .collect(Collectors.toList());
    }

    private static Order withItems(Order order) {
        order.setItems(createItems());
        return order;
    }

    private static Collection<OrderItem> createItems() {
        return Arrays.stream(ItemActionType.values())
                .map(type -> new OrderItem("Action", type))
                .collect(Collectors.toList());
    }
}
