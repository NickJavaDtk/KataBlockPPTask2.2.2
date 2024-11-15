package web.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.model.Car;
import spring.service.CarService;


import java.util.List;

@Controller
@RequestMapping(value = "/cars", produces = "text/html; charset=UTF-8")
public class CarController {

    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public String getViewCars(@RequestParam(value = "count", required = false) String count, Model model) {
        List<Car> carList = null;
        if (count == null) {
            carList = service.getCars(0);
            model.addAttribute("list", carList);
        } else {
            carList = service.getCars(Integer.parseInt(count));
            model.addAttribute("list", carList);
        }

        return "viewcar";
    }

}
