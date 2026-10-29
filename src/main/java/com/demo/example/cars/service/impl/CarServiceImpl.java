package com.demo.example.cars.service.impl;

import com.demo.example.cars.model.Car;
import com.demo.example.cars.repository.CarRepository;
import com.demo.example.cars.service.CarService;
import java.util.List;
import java.util.Optional;
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
    return carsRepository.findAll()
        .collectList()
        .flatMapMany(cars -> Flux.fromIterable(availableCars(cars)));
  }

  @Override
  public Mono<Car> getCar(String id) {
    return carsRepository.findById(id)
        .flatMap(car -> Mono.justOrEmpty(car.available()));
  }

  @Override
  public Mono<Car> deleteCar(String id) {
    return carsRepository.findById(id)
        .map(Car::logicallyDeleted)
        .flatMap(carsRepository::save);
  }

  private static List<Car> availableCars(List<Car> cars) {
    return cars.stream()
        .map(Car::available)
        .flatMap(Optional::stream)
        .toList();
  }
}
