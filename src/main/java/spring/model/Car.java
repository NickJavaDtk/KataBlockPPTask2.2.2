package spring.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "mele_age")
    private int mileage;

    private static List<Car> carList;

    public Car() {
        Car lada = new Car("Ваз 2101", 120000);
        Car bmw = new Car("525", 750000);
        Car toyota = new Car("Camry", 320000);
        Car kitai = new Car("JAC", 5000);
        Car electric = new Car("Tesla", 80000);
        carList = List.of(lada, bmw, toyota, kitai, electric);
    }

    public Car(String model, int mileage) {
        this.model = model;
        this.mileage = mileage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public static List<Car> getCarList() {
        return carList;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}
