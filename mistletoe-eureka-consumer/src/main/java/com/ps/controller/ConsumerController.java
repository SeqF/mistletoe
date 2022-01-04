package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author paksu
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    private static final String host = "http://eureka-producer";

    @GetMapping("consumer/info")
    public String info() {
        return restTemplate.getForObject(host + "/producer/info", String.class);
    }
}
