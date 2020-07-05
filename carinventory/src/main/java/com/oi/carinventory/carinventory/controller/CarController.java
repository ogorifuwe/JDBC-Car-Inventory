package com.oi.carinventory.carinventory.controller;

import com.oi.carinventory.carinventory.model.Car;
import com.oi.carinventory.carinventory.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

  @Autowired
  private CarService carService;


  @RequestMapping(value = "/car-inventory", method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public Car createCar(@RequestBody Car car) {
    Car newCar = carService.createCar(car);
    return newCar;
  }

  @RequestMapping(value = "/car-inventory/retrieve-by-id/{id}", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public Car retrieveCarById(@PathVariable("id") int carId) {
    Car car = carService.retrieveCar(carId);
    return car;
  }

  @RequestMapping(value = "/car-inventory/retrieve-all-cars", method = RequestMethod.GET)
  @ResponseStatus(HttpStatus.OK)
  public List<Car> retrieveAllCars() {
    List<Car> cars = carService.retrieveCars();
    return cars;
  }

  @RequestMapping(value = "/car-inventory/update-car/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.CREATED)
  public Car updateCar(@RequestBody Car car, @PathVariable("id") int id) {
    Car updatedCar = carService.updateCar(car);
    return updatedCar;
  }

  @RequestMapping(value = "/car-inventory/delete-car/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.GONE)
  public void deleteCar(@PathVariable("id") int id) {
    carService.deleteCar(id);
  }

  // Retrieve Car By Make

  // Retrieve Car By Model

  // Retrieve Car By Year

}
