package com.epam.techtalk.spring.integration.planet.express.app.xml;

import com.epam.techtalk.spring.integration.planet.express.app.xml.common.PlanetExpress;
import com.epam.techtalk.spring.integration.planet.express.common.OrderProducer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlanetExpressWithXml {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("PlanetExpress.xml");
        final PlanetExpress planetExpress = context.getBean(PlanetExpress.class);

        OrderProducer.produce(3)
                .stream()
                .forEach(planetExpress::placeOrder);
    }
}
