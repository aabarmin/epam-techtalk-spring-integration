package com.epam.techtalk.spring.integration.planet.express.app.adapters;

import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;
import com.epam.techtalk.spring.integration.planet.express.common.PlanetExpress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@SpringBootApplication
@IntegrationComponentScan(basePackageClasses = PlanetExpress.class)
public class PlanetExpressWithAdapters {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(PlanetExpressWithAdapters.class);
    }


}
