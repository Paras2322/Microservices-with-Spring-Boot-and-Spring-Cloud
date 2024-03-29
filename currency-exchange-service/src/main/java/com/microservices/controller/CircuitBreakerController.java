package com.microservices.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name="default")
//      @Bulkhead(name="default")
    //10s => 1000 calls to the sample api
    public String sampleApi() {
        logger.info("sample Api call");
//        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//        return entity.getBody();
        return "sample-api";
    }

    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }
}
