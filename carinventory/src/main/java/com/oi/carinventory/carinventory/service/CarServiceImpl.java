package com.oi.carinventory.carinventory.service;

import com.oi.carinventory.carinventory.dao.CarDao;
import com.oi.carinventory.carinventory.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {

  @Autowired
  private CarDao carDao;

  @Override
  @Transactional
  public Car createCar(Car car) {
    return carDao.createCar(car);
  }

  @Override
  public Car retrieveCar(int id) {
    return carDao.retrieveCar(id);
  }

  @Override
  public List<Car> retrieveCars() {
    return carDao.retrieveCars();
  }

  @Override
  public List<Car> retrieveCarsByColor(String color) {
    return carDao.retrieveCarsByColor(color);
  }

  @Override
  public Car updateCar(Car car) {
    return carDao.updateCar(car);
  }

  @Override
  public void deleteCar(int id) {
    carDao.deleteCar(id);
  }
}
