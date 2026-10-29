package com.demo.example.cars.service;

import com.demo.example.cars.model.Car;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarService {

    Flux<Car> listCar();

    Mono<Car> getCar(String id);

    Mono<Car> deleteCar(String id);
}