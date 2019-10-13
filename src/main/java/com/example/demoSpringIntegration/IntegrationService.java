package com.example.demoSpringIntegration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class IntegrationService {

    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void mapMessage(Message<String> message) throws MessagingException {
        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
       // MessageBuilder.fromMessage(message);
        Message<String> newMessage = MessageBuilder.withPayload("hello "+message.getPayload()).build();
        replyChannel.send(newMessage);
    }
}
