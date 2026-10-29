package com.demo.example.cars.service.impl;

import com.demo.example.cars.model.Car;
import com.demo.example.cars.repository.CarRepository;
import com.demo.example.cars.service.CarService;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

  private final CarRepository carsRepository;

  @Override
  public List<Car> listCar() {
    return carsRepository.findAll();
  }

  @Override
  public Car getCar(String id) {
    return carsRepository.findById(id)
        .orElseThrow(() -> new NoSuchElementException("No existe id: " + id));
  }

  @Override
  public boolean deleteCar(String id) {
    carsRepository.deleteById(id);
    return true;
  }

}
