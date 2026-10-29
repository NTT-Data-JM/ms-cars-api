package com.demo.example.cars.controller;

import com.demo.example.cars.dto.CarResponse;
import com.demo.example.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @GetMapping
    public Flux<CarResponse> listCars() {
        return carService.listCar()
                .map(CarResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<CarResponse>> getCars(
            @PathVariable String id) {

        return carService.getCar(id)
                .map(car -> ResponseEntity.ok(CarResponse.from(car)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteCars(
            @PathVariable String id) {

        return carService.deleteCar(id)
                .map(car -> ResponseEntity.noContent().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}