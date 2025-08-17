package com.learn.with.mayur.a.config;

import io.github.resilience4j.ratelimiter.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimiterConfig {
     @Bean
     public RateLimiter serviceARateLimiter() {
         return RateLimiter.of("serviceARateLimiter",
                 io.github.resilience4j.ratelimiter.RateLimiterConfig.custom()
                         .limitForPeriod(10)
                         .limitRefreshPeriod(Duration.ofSeconds(1))
                         .timeoutDuration(Duration.ofSeconds(1))
                         .build());
     }
}
