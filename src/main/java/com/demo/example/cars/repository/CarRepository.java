package com.demo.example.cars.repository;

import com.demo.example.cars.model.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends ReactiveMongoRepository<Car, String> {

    Flux<Car> findByStatus(String status);

    Mono<Car> findByIdAndStatus(String id, String status);
}