package com.demo.example.cars.dto;

import com.demo.example.cars.model.Car;

public record CarResponse(
        String id,
        String brand,
        String model,
        String price,
        String status
) {
    public static CarResponse from(Car car) {
        return new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPrice(),
                car.getStatus()
        );
    }
}