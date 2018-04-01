package com.epam.techtalk.spring.integration.planet.express.app.simple;

import com.epam.techtalk.spring.integration.planet.express.common.OrderProducer;
import com.epam.techtalk.spring.integration.planet.express.common.PlanetExpress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

/**
 * Output orders to console.
 */
@SpringBootApplication
@IntegrationComponentScan(basePackageClasses = PlanetExpress.class)
public class Simple01 {
    public static void main(String[] args) throws Exception {
        final ConfigurableApplicationContext context = SpringApplication.run(Simple01.class);

        final PlanetExpress planetExpress = context.getBean(PlanetExpress.class);

        OrderProducer.produce(3).stream()
                .forEach(planetExpress::placeOrder);

    }

    @Bean(name = "incoming.orders")
    public MessageChannel incomingOrdersChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow simpleFlow() {
        return IntegrationFlows.from("incoming.orders")
                .handle(System.err::println)
                .get();
    }
}
