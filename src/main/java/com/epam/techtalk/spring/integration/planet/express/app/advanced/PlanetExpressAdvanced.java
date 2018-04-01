package com.epam.techtalk.spring.integration.planet.express.app.advanced;

import com.epam.techtalk.spring.integration.planet.express.common.Delivery;
import com.epam.techtalk.spring.integration.planet.express.common.Order;
import com.epam.techtalk.spring.integration.planet.express.common.OrderItem;
import com.epam.techtalk.spring.integration.planet.express.common.OrderProducer;
import com.epam.techtalk.spring.integration.planet.express.common.PlanetExpress;
import com.epam.techtalk.spring.integration.planet.express.common.QueueNames;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @TODO write class description
 */
@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan(basePackageClasses = PlanetExpress.class)
public class PlanetExpressAdvanced {
    public static void main(String[] args) {
        final ConfigurableApplicationContext context = SpringApplication.run(PlanetExpressAdvanced.class);
        final PlanetExpress planetExpress = context.getBean(PlanetExpress.class);

        OrderProducer.produce(3)
                .stream()
                .forEach(planetExpress::placeOrder);
    }

    @Bean
    public IntegrationFlow professorFlow() {
        return IntegrationFlows.from(QueueNames.INPUT_QUEUE)
                .split(Order.class, Order::getItems)
                .log(LoggingHandler.Level.WARN, "Professor processing ...")
                .channel(QueueNames.HERMES_QUEUE)
                .get();
    }

    @Bean
    public IntegrationFlow hermesFlow() {
        return IntegrationFlows.from(QueueNames.HERMES_QUEUE)
                .log(LoggingHandler.Level.WARN, "Hermes processing ...")
                .<OrderItem, String>route(item -> {
                    switch (item.getActionType()) {
                        case BEND: return QueueNames.BENDER_QUEUE;
                        case CUT: return QueueNames.ZOIDBERG_QUEUE;
                    }
                    throw new IllegalArgumentException("Unsupported order item type");
                })
                .get();
    }

    @Bean
    public IntegrationFlow benderFlow() {
        return IntegrationFlows.from(QueueNames.BENDER_QUEUE)
                .transform((OrderItem item) -> {
                    item.setProcessed(true);
                    return item;
                })
                .log(LoggingHandler.Level.WARN, "Bender processing ...")
                .channel(QueueNames.FRY_QUEUE)
                .get();
    }

    @Bean
    public IntegrationFlow zoidbergFlow() {
        return IntegrationFlows.from(QueueNames.ZOIDBERG_QUEUE)
                .transform((OrderItem item) -> {
                    item.setProcessed(true);
                    return item;
                })
                .log(LoggingHandler.Level.WARN, "Zoidberg processing ...")
                .channel(QueueNames.FRY_QUEUE)
                .get();
    }

    @Bean
    public IntegrationFlow fryFlow() {
        return IntegrationFlows.from(QueueNames.FRY_QUEUE)
                .aggregate(spec -> spec.outputProcessor(group -> {
                    final List<OrderItem> items = group.getMessages().stream()
                            .map(message -> (OrderItem) message.getPayload())
                            .collect(Collectors.toList());
                    return new Delivery(items);
                }))
                .log(LoggingHandler.Level.WARN, "Fry processing ...")
                .channel(QueueNames.LEELA_QUEUE)
                .get();
    }

    @Bean
    public IntegrationFlow leelaFlow() {
        return IntegrationFlows.from(QueueNames.LEELA_QUEUE)
                .log(LoggingHandler.Level.WARN, "Leela processing ...")
                .<Delivery>handle(delivery -> System.out.println(delivery))
                .get();
    }
}
