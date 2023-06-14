package eduardo.sinc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eduardo.sinc.domain.car.Car;
import eduardo.sinc.domain.car.CarDTO;
import eduardo.sinc.domain.car.CarRepository;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://54.173.116.19:3000")
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        var allCars = carRepository.findAll();
        return ResponseEntity.status(200).body(allCars);
    }

    @GetMapping
    public ResponseEntity<List<Car>> searchCars(@RequestParam String search) {
        List<Car> searchResult = carRepository.findByPlateOrModelOrBrand(search, search, search);
        return ResponseEntity.status(200).body(searchResult);
    }

    @PostMapping
    public ResponseEntity<Car> registerCar(@RequestBody @Valid @Validated CarDTO data) {
        Car newCar = carRepository.save(new Car(data));
        return ResponseEntity.status(201).body(newCar);
    }

    @PutMapping()
    public ResponseEntity<Car> updateCar(@RequestBody @Valid CarDTO data, @RequestParam Integer id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Car newCar = carRepository.save(new Car(id, data));
        return ResponseEntity.ok(newCar);
    }

    @DeleteMapping
    public ResponseEntity<Car> deleteCar(@RequestParam Integer id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        carRepository.deleteById(id);
        return ResponseEntity.ok().body(car.get());
    }
}
