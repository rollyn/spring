package com.example.demoSpringIntegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.graph.MessageGatewayNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class IntegrationController {

    @Autowired
    private IntegrationGateway integrationGateway;

    @GetMapping("{name}")
    public String greet(@PathVariable("name") String name) {
        return integrationGateway.send(name);
    }

    //multiple recipient example
    @GetMapping("all/{name}")
    public String greetAll(@PathVariable("name") String name) {
        return integrationGateway.sendAll(name);
    }
}
