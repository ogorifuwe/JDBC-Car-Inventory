package com.oi.carinventory.carinventory.dao;

import com.oi.carinventory.carinventory.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CarDaoJdbcTemplateImpl implements CarDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private static final String INSERT_INTO_CAR_SQL = "insert into car (color, make, model, year) values (?, ?, ?, ?);";

  private static final String SELECT_CAR_BY_ID_SQL =
          "select * from car where id = ?";

  private static final String SELECT_ALL_CARS_SQL = "select * from car";

  private static final String SELECT_CAR_BY_COLOR_SQL =
          "select * from car where color = ?";

  private static final String UPDATE_CAR_SQL =
          "update car set color = ?, make = ?, model = ?, year = ? where id = ?";

  private static final String DELETE_SQL = "delete from car where id = ?";

  @Override
  public Car createCar(Car car) {
    jdbcTemplate.update(
            INSERT_INTO_CAR_SQL,
            car.getColor(),
            car.getMake(),
            car.getModel(),
            car.getYear());

    String sql = "select last_insert_id()";

    int carId = jdbcTemplate.queryForObject(sql, Integer.class);

    return car;
  }

  @Override
  public Car retrieveCar(int id) {
    try {
      return jdbcTemplate.queryForObject(SELECT_CAR_BY_ID_SQL, this::mapRowToCar, id);
    } catch (EmptyResultDataAccessException e) {
        return null;
    }
  }

  @Override
  public List<Car> retrieveCars() {
    return jdbcTemplate.query(SELECT_ALL_CARS_SQL, this::mapRowToCar);
  }

  @Override
  public List<Car> retrieveCarsByColor(String color) {
    return jdbcTemplate.query(SELECT_CAR_BY_COLOR_SQL, this::mapRowToCar, color);
  }

  @Override
  public Car updateCar(Car car) {
    jdbcTemplate.update(UPDATE_CAR_SQL,
            car.getColor(),
            car.getMake(),
            car.getModel(),
            car.getYear(),
            car.getId());

    return car;
  }

  @Override
  public void deleteCar(int id) {
    jdbcTemplate.update(DELETE_SQL, id);
  }

  private Car mapRowToCar(ResultSet rs, int rowNum) throws SQLException {

    Car car = new Car();
    car.setId(rs.getInt("id"));
    car.setColor(rs.getString("color"));
    car.setMake(rs.getString("make"));
    car.setModel(rs.getString("model"));
    car.setYear(rs.getString("year"));

    return car;
  }
}
