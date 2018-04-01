package com.epam.techtalk.spring.integration.planet.express.app.basic;

import com.epam.techtalk.spring.integration.planet.express.common.OrderProducer;
import com.epam.techtalk.spring.integration.planet.express.common.PlanetExpress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@IntegrationComponentScan(basePackageClasses = PlanetExpress.class)
@SpringBootApplication
public class PlanetExpressBasic {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(PlanetExpressBasic.class);
        final PlanetExpress planetExpress = context.getBean(PlanetExpress.class);

        OrderProducer.produce(3)
                .stream()
                .forEach(planetExpress::placeOrder);
    }
}
