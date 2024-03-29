package com.example.demoSpringIntegration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.RecipientListRouter;
import org.springframework.messaging.MessageChannel;

@Configuration
@IntegrationComponentScan
@EnableIntegration
public class IntegrationConfig {

    @Bean
    public MessageChannel receiverChannel() {
        return new DirectChannel();
    }

    @Bean
    public  MessageChannel replyChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "integration.recipient.channel")
    public RecipientListRouter sendAll() {
        RecipientListRouter router = new RecipientListRouter();
        router.addRecipient("recipient.2");
        router.addRecipient("recipient.1");
        return router;
    }


}
