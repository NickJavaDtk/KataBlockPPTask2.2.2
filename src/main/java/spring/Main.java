package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.model.Car;
import spring.service.CarService;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out ::println);
        CarService service =  context.getBean(CarService.class);

        Car lada = new Car("Ваз 2101", 120000);
        Car bmw = new Car("525", 750000);
        Car toyota = new Car("Camry", 320000);
        Car kitai = new Car("JAC", 5000);
        Car electric = new Car("Tesla", 80000);

        service.addCar(lada);
        service.addCar(bmw);
        service.addCar(toyota);
        service.addCar(kitai);
        service.addCar(electric);

        service.getCars(2).stream().forEach(System.out ::println);

    }

}
