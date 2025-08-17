package com.learn.with.mayur.a.service;

import org.springframework.stereotype.Service;

@Service
public class FindCarService {
    public String findCar(String carId) {
        return "Car found " + carId + " successfully!";
    }
}
