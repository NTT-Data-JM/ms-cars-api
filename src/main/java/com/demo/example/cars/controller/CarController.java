package com.demo.example.cars.controller;

import com.demo.example.cars.model.Car;
import com.demo.example.cars.service.CarService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CarController {

  private final CarService carService;

  @GetMapping("/car")
  public List<Car> listCars(@RequestHeader Map<String, String> headers) {
    return carService.listCar();
  }

  @GetMapping("/car/{id}")
  public Car getCars(@RequestHeader Map<String, String> headers, @PathVariable String id) {
    return carService.getCar(id);
  }

  @DeleteMapping("/car/{id}")
  public boolean deleteCars(@RequestHeader Map<String, String> headers, @PathVariable String id) {
    return carService.deleteCar(id);
  }

}
