package com.epam.techtalk.spring.integration.planet.express.app.xml.common;

import com.epam.techtalk.spring.integration.planet.express.common.Order;

/**
 * Planet express messaging gateway for XML configuration.
 */
public interface PlanetExpress {
    void placeOrder(Order order);
}
