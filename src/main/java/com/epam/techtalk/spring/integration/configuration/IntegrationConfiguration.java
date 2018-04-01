package com.epam.techtalk.spring.integration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.SourcePollingChannelAdapterSpec;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * SI configuration class.
 */
@EnableIntegration
@Configuration
public class IntegrationConfiguration {
    @Bean
    public MessageChannel p2pChannel() {
        return new DirectChannel();
    }

    @Bean
    @InboundChannelAdapter(value = "p2pChannel", poller = @Poller(fixedDelay = "1000"))
    public MessageSource<File> fileMessageSource() {
        final Path filesPath = Paths.get(
                System.getProperty("user.home"),
                "IdeaProjects",
                "epam-spring-integration-techtalk",
                "sources"
        );
        final FileReadingMessageSource messageSource = new FileReadingMessageSource();
        messageSource.setDirectory(filesPath.toFile());
        return messageSource;
    }

    @Bean
    @ServiceActivator(inputChannel = "p2pChannel")
    public MessageHandler fileMessageHandler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println(message);
            }
        };
    }

    // @Bean
    public IntegrationFlow integrationFlow(MessageSource<File> fileSource) {
        return IntegrationFlows.from(fileSource, c -> c.poller(Pollers.fixedRate(1000)))
                .handle(new GenericHandler<Object>() {
                    @Override
                    public Object handle(Object payload, Map<String, Object> headers) {
                        System.out.println(payload);
                        return true;
                    }
                })
                .get();
    }
}
