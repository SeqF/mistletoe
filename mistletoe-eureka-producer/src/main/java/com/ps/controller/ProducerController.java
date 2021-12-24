package com.ps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author paksu
 */
@RestController
public class ProducerController {

    @GetMapping("/info")
    public String info() {
        String info = "Hello,this is eureka producer";
        return info;
    }
}
