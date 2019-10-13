package com.example.demoSpringIntegration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {

    @Gateway(requestChannel = "integration.gateway.channel")
    public String send(String name);

    @Gateway(requestChannel = "integration.recipient.channel")
    String sendAll(String name); // serviceactivator in config
}
