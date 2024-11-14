package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Car;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {

    private Car car;

    public CarDaoImp(Car car) {
        this.car = car;
    }

    @Override
    public void addCar(Car car) {
       Car.getCarList().add(car);
    }

    @Override
    public List<Car> getCars(int quantity) {
        return Car.getCarList().stream().limit(quantity).collect(Collectors.toList());
    }
}
