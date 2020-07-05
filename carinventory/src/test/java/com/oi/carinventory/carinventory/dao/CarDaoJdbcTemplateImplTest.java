package com.oi.carinventory.carinventory.dao;


import com.oi.carinventory.carinventory.model.Car;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarDaoJdbcTemplateImplTest {

  @Autowired
  private CarDao carDao;

  @Before
  public void setUp() {
    // clean up DB
    List<Car> cars = carDao.retrieveCars();

    cars.stream()
            .forEach(car -> carDao.deleteCar(car.getId()));
  }


  @Test
  public void testForCreateCarAndRetrieveCarById() {

    // create car object and place in DB
    Car car = new Car();
    car.setColor("White");
    car.setMake("Toyota");
    car.setModel("Big For Nothing");
    car.setYear("2005");
    Car createdCar = carDao.createCar(car);

    // retrieve car from DB
    Car retrievedCar = carDao.retrieveCar(createdCar.getId());

    assertEquals(createdCar, retrievedCar);
  }

  @Test
  public void testForRetrieveCarByColor() {

    Car car = new Car();
    car.setColor("White");
    car.setMake("Toyota");
    car.setModel("Big For Nothing");
    car.setYear("2005");
    Car createdCar = carDao.createCar(car);

    Car car1 = new Car();
    car1.setColor("White");
    car1.setMake("Toyota");
    car1.setModel("Corolla");
    car1.setYear("2005");
    Car createdCar1 = carDao.createCar(car1);

    Car car2 = new Car();
    car2.setColor("Red");
    car2.setMake("Honda");
    car2.setModel("Civic");
    car2.setYear("2005");
    Car createdCar2 = carDao.createCar(car2);

    List<Car> whiteCars = carDao.retrieveCarsByColor("White");
    List<Car> redCars = carDao.retrieveCarsByColor("Red");

    assertEquals(2, whiteCars.size());
    assertEquals(1, redCars.size());

  }


  @Test
  public void testForUpdateCar() {

    // create a car object in DB
    Car car = new Car();
    car.setColor("White");
    car.setMake("Toyota");
    car.setModel("Big For Nothing");
    car.setYear("2005");
    Car createdCar = carDao.createCar(car);


    // update the car object
    createdCar.setColor("Black");
    createdCar.setMake("Toyota");
    createdCar.setModel("Big For Nothing");
    createdCar.setYear("2006");
    Car updateCar = carDao.updateCar(createdCar);


    // assert that both objects are same
    Car retrievedCar = carDao.retrieveCar(updateCar.getId());
    assertEquals(updateCar, retrievedCar);


  }


}

