package com.demo.example.cars.service.impl;

import com.demo.example.cars.model.Car;
import com.demo.example.cars.repository.CarRepository;
import com.demo.example.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carsRepository;

    public CarServiceImpl(CarRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Flux<Car> listCar() {
        return carsRepository.findByStatus("1");
    }

    @Override
    public Mono<Car> getCar(String id) {
        return carsRepository.findByIdAndStatus(id, "1");
    }

    @Override
    public Mono<Car> deleteCar(String id) {
        return carsRepository.findById(id)
                .flatMap(car -> {
                    car.setStatus("0");
                    return carsRepository.save(car);
                });
    }
}