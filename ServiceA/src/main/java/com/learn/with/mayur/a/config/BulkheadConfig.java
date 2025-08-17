package com.learn.with.mayur.a.config;

import io.github.resilience4j.bulkhead.Bulkhead;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class BulkheadConfig {

    @Bean
    public Bulkhead serviceABulkhead() {
        return Bulkhead.of("serviceABulkhead",
                io.github.resilience4j.bulkhead.BulkheadConfig.custom()
                        .maxConcurrentCalls(10)
                        .maxWaitDuration(Duration.ofSeconds(10))
                        .build());
    }
}
