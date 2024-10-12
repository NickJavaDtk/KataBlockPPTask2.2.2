package spring.service;

import spring.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    List<Car> getCars(int quantity);

    List<Car> getCarsView(String count);
}
