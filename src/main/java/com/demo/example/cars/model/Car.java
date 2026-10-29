package com.demo.example.cars.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document(collection = "cars")
public class Car {

  @BsonId
  private String id;
  private String brand;
  private String model;
  private Double price;
  private boolean status;

}
