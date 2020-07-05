package com.oi.carinventory.carinventory.model;

import java.util.Objects;


public class Car {

  private int id;
  private String color;
  private String make;
  private String model;
  private String year;

  public Car() {
  }

  public Car(int id, String color, String make, String model, String year) {
    this.id = id;
    this.color = color;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return id == car.id &&
            color.equals(car.color) &&
            make.equals(car.make) &&
            model.equals(car.model) &&
            year.equals(car.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, color, make, model, year);
  }

  @Override
  public String toString() {
    return "Car{" +
            "id=" + id +
            ", color='" + color + '\'' +
            ", make='" + make + '\'' +
            ", model='" + model + '\'' +
            ", year='" + year + '\'' +
            '}';
  }
}
