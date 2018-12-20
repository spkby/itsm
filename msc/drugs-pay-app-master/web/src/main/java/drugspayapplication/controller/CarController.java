package drugspayapplication.controller;

import drugspayapplication.entity.Car;
import drugspayapplication.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @GetMapping("/")
    @ResponseBody
    Iterable<Car> getAll() {
        return carRepository.findAll();
    }

    @PostMapping("/")
    @ResponseBody
    void postCar(@RequestBody Car car) {
        carRepository.save(car);
    }
}
