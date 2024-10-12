package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.model.Car;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addCar(Car car) {
        Session session = sessionFactory.openSession();
        session.save(car);
        session.close();
    }

    @Override
    public List<Car> getCars(int quantity) {
        String hql = "From Car";
        List<Car> list;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        if (quantity == 0) {
            list = query.getResultList();
        } else {
            query.setMaxResults(quantity);
            list = query.getResultList();
        }
        return list;
    }
}
