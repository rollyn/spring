package com.example.demoSpringIntegration;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class RecipientService {

    @ServiceActivator(inputChannel = "recipient.1")
    public void recipient1(Message<String> msg) throws MessagingException {
        System.out.println("RECIPIENT 1");
        System.out.println(msg.getPayload());
        MessageChannel replyChannel = (MessageChannel) msg.getHeaders().getReplyChannel();
        throw new MessagingException("AAA");
//        Message<String> newMessage = MessageBuilder.withPayload("RECIPIENT 1").build();
//        replyChannel.send(newMessage);
    }

    @ServiceActivator(inputChannel = "recipient.2")
    public void recipient2(Message<String> msg) throws MessagingException {
        System.out.println("RECIPIENT 2");
        System.out.println(msg.getPayload());
        MessageChannel replyChannel = (MessageChannel) msg.getHeaders().getReplyChannel();

        Message<String> newMessage = MessageBuilder.withPayload("RECIPIENT 1").build();
        replyChannel.send(newMessage);
    }
}
