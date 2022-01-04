package com.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author paksu
 */
@RestController
public class ProducerController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Registration registration;

    @GetMapping("producer/info")
    public String info() {

        List<ServiceInstance> serviceInstances = client.getInstances(registration.getServiceId());
        Optional<ServiceInstance> serviceInstanceOptional =
                serviceInstances.stream().filter(serviceInstance -> serviceInstance.getPort() == registration.getPort()).findFirst();
        if (serviceInstanceOptional.isPresent()) {

        }

        String info = "Hello,this is eureka producer";
        return info;
    }
}
