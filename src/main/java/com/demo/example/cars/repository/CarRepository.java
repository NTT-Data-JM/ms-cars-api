package com.demo.example.cars.repository;

import com.demo.example.cars.model.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends ReactiveMongoRepository<Car, String> {
}
