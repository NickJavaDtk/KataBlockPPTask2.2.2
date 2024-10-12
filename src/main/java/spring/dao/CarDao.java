package spring.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.Car;

import java.util.List;

public interface CarDao {

    void addCar(Car car);

    List<Car> getCars(int quantity);

}
