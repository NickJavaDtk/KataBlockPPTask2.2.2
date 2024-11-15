package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.CarDaoImp;
import spring.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService {


    private CarDaoImp carDao;

    public CarServiceImp(CarDaoImp carDao) {
        this.carDao = carDao;
    }

    @Override
    @Transactional
    public List<Car> getCars(int quantity) {
        return quantity == 0 ? carDao.getAllCars() : carDao.getCars(quantity);
    }


}
