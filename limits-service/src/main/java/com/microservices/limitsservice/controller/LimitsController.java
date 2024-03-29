package com.microservices.limitsservice.controller;

import com.microservices.limitsservice.bean.Limits;
import com.microservices.limitsservice.configuration.LimitsServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private LimitsServiceConfiguration configuration;

    @GetMapping("/limits")
    public Limits retrieveLimits(){
//        return new Limits(1,1000);
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
