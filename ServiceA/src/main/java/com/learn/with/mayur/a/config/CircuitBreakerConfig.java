package com.learn.with.mayur.a.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfig {

    @Bean
    public CircuitBreaker serviceACircuitBreaker() {
        return CircuitBreaker.of("serviceACircuitBreaker",
                io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.custom()
                        .failureRateThreshold(50)
                        .automaticTransitionFromOpenToHalfOpenEnabled(true)
                        .waitDurationInOpenState(Duration.ofSeconds(5))
                        .permittedNumberOfCallsInHalfOpenState(3)
                        .slidingWindow(5,
                                5,
                                io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                        .build());
    }
}
