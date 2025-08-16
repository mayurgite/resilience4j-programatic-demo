package com.learn.with.mayur.a.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "resilience4j.bulkhead.instances")
public class BulkheadProperties {

    public static class ServiceA {
        private String maxWaitDuration;
        private String maxConcurrentCalls;

        public String getMaxWaitDuration() {
            return maxWaitDuration;
        }

        public void setMaxWaitDuration(String maxWaitDuration) {
            this.maxWaitDuration = maxWaitDuration;
        }

        public String getMaxConcurrentCalls() {
            return maxConcurrentCalls;
        }

        public void setMaxConcurrentCalls(String maxConcurrentCalls) {
            this.maxConcurrentCalls = maxConcurrentCalls;
        }
    }
}
