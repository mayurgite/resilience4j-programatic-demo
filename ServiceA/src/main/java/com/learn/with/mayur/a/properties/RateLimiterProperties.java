package com.learn.with.mayur.a.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("resilience4j.ratelimiter.instances")
public class RateLimiterProperties {
}
