package com.learn.with.mayur.a.config;

import io.github.resilience4j.retry.Retry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfig {

    @Bean
    public Retry serviceARetry() {
        return Retry.of("serviceARetry",
                io.github.resilience4j.retry.RetryConfig.custom()
                        .maxAttempts(3)
                        .waitDuration(java.time.Duration.ofMillis(500))
                        .build());
    }
}
