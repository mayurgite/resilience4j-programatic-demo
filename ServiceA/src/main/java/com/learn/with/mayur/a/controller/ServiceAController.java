package com.learn.with.mayur.a.controller;

import com.learn.with.mayur.a.service.FindCarService;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find")
public class ServiceAController {

    private final CircuitBreaker serviceACircuitBreaker;
    private final Bulkhead serviceABulkhead;
    private final RateLimiter serviceARateLimiter;
    private final Retry serviceARetry;
    private final FindCarService service;
    private int count = 1;

    public ServiceAController(FindCarService service, CircuitBreaker serviceACircuitBreaker, Bulkhead serviceABulkhead,
                              RateLimiter serviceARateLimiter, Retry serviceARetry) {
        this.service = service;
        this.serviceACircuitBreaker = serviceACircuitBreaker;
        this.serviceABulkhead = serviceABulkhead;
        this.serviceARateLimiter = serviceARateLimiter;
        this.serviceARetry = serviceARetry;
    }

    @GetMapping("/car")
    public String serviceA() {
        return Decorators.ofSupplier(
                        () -> service.findCar("carId" + count++)
                ).withCircuitBreaker(serviceACircuitBreaker)
                .withBulkhead(serviceABulkhead)
                .withRateLimiter(serviceARateLimiter)
                .withRetry(serviceARetry)
                .decorate()
                .get();
    }

}
