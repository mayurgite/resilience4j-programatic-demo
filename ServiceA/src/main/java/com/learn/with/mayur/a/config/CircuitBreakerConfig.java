package com.learn.with.mayur.a.config;

import com.learn.with.mayur.a.properties.CircuitBreakerProperties;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class CircuitBreakerConfig {

    private final CircuitBreakerProperties properties;

    public CircuitBreakerConfig(CircuitBreakerProperties properties){
        this.properties = properties;
    }

    @Bean
    public CircuitBreaker serviceACircuitBreaker(){
        return CircuitBreaker.of("serviceACircuitBreaker",
                io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.custom()
                        .failureRateThreshold(properties.getServiceA().getFailureRateThreshold())
                        .automaticTransitionFromOpenToHalfOpenEnabled(properties.getServiceA().isAutomaticTransitionFromOpenToHalfOpenEnabled())
                        .waitDurationInOpenState(Duration.parse(properties.getServiceA().getWaitDurationInOpenState()))
                        .permittedNumberOfCallsInHalfOpenState(properties.getServiceA().getPermittedNumberOfCallsInHalfOpenState())
                        .slidingWindow(properties.getServiceA().getSlidingWindowSize(),
                                properties.getServiceA().getMinimumNumberOfCalls(),
                                io.github.resilience4j.circuitbreaker.CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                        .build());
    }
}
