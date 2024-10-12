package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.CarDaoImp;
import spring.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    private CarDaoImp carDao;


    @Override
    @Transactional
    public void addCar(Car car) {
        carDao.addCar(car);
    }

    @Override
    @Transactional
    public List<Car> getCars(int quantity) {
        return carDao.getCars(quantity);
    }

    @Override
    public List<Car> getCarsView(String count) {
        List<Car> carList = null;
        if (count != null) {
            Integer quantity = Integer.parseInt(count);
            if (quantity > 0) {
                if (quantity >= 5) {
                    carList = getCars(5);
                } else {
                    carList = getCars(quantity);
                }
            }
        } else {
            carList = getCars(0);
        }
        return carList;
    }
}
