package com.learn.with.mayur.a.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("resilience4j.circuitbreaker.instances")
public class CircuitBreakerProperties {

    private ServiceA serviceA;

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    public static class ServiceA{
        private boolean registerHealthIndicator;
        private int eventConsumerBufferSize;
        private int failureRateThreshold;
        private int minimumNumberOfCalls;
        private boolean automaticTransitionFromOpenToHalfOpenEnabled;
        private String waitDurationInOpenState;
        private int permittedNumberOfCallsInHalfOpenState;
        private int slidingWindowSize;
        private String slidingWindowType;

        public String getSlidingWindowType() {
            return slidingWindowType;
        }

        public void setSlidingWindowType(String slidingWindowType) {
            this.slidingWindowType = slidingWindowType;
        }

        public int getSlidingWindowSize() {
            return slidingWindowSize;
        }

        public void setSlidingWindowSize(int slidingWindowSize) {
            this.slidingWindowSize = slidingWindowSize;
        }

        public int getPermittedNumberOfCallsInHalfOpenState() {
            return permittedNumberOfCallsInHalfOpenState;
        }

        public void setPermittedNumberOfCallsInHalfOpenState(int permittedNumberOfCallsInHalfOpenState) {
            this.permittedNumberOfCallsInHalfOpenState = permittedNumberOfCallsInHalfOpenState;
        }

        public String getWaitDurationInOpenState() {
            return waitDurationInOpenState;
        }

        public void setWaitDurationInOpenState(String waitDurationInOpenState) {
            this.waitDurationInOpenState = waitDurationInOpenState;
        }

        public boolean isAutomaticTransitionFromOpenToHalfOpenEnabled() {
            return automaticTransitionFromOpenToHalfOpenEnabled;
        }

        public void setAutomaticTransitionFromOpenToHalfOpenEnabled(boolean automaticTransitionFromOpenToHalfOpenEnabled) {
            this.automaticTransitionFromOpenToHalfOpenEnabled = automaticTransitionFromOpenToHalfOpenEnabled;
        }

        public int getMinimumNumberOfCalls() {
            return minimumNumberOfCalls;
        }

        public void setMinimumNumberOfCalls(int minimumNumberOfCalls) {
            this.minimumNumberOfCalls = minimumNumberOfCalls;
        }

        public int getFailureRateThreshold() {
            return failureRateThreshold;
        }

        public void setFailureRateThreshold(int failureRateThreshold) {
            this.failureRateThreshold = failureRateThreshold;
        }

        public int getEventConsumerBufferSize() {
            return eventConsumerBufferSize;
        }

        public void setEventConsumerBufferSize(int eventConsumerBufferSize) {
            this.eventConsumerBufferSize = eventConsumerBufferSize;
        }

        public boolean isRegisterHealthIndicator() {
            return registerHealthIndicator;
        }

        public void setRegisterHealthIndicator(boolean registerHealthIndicator) {
            this.registerHealthIndicator = registerHealthIndicator;
        }
    }
}
