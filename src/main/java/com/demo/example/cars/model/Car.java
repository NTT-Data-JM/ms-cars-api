package com.demo.example.cars.model;

import java.util.Optional;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public record Car(
    @Id String id,
    String brand,
    String model,
    String price,
    String status
) {

  public Optional<Car> available() {
    return "1".equals(status) ? Optional.of(this) : Optional.empty();
  }

  public Car logicallyDeleted() {
    return new Car(id, brand, model, price, "0");
  }
}
