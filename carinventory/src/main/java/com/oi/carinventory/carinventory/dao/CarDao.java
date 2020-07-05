package com.oi.carinventory.carinventory.dao;

import com.oi.carinventory.carinventory.model.Car;

import java.util.List;

public interface CarDao {

  public Car createCar(Car car);

  public Car retrieveCar(int id);

  public List<Car> retrieveCars();

  public List<Car> retrieveCarsByColor(String color);

  public Car updateCar(Car car);

  public void deleteCar(int id);

}
