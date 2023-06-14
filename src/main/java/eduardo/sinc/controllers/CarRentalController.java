package eduardo.sinc.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import eduardo.sinc.domain.car.CarRepository;
import eduardo.sinc.domain.carRental.CarRental;
import eduardo.sinc.domain.carRental.CarRentalRepository;
import eduardo.sinc.domain.carRental.dto.RegisterDTO;
import eduardo.sinc.domain.client.Client;
import eduardo.sinc.domain.client.ClientRepository;

@RestController
@CrossOrigin(origins = "http://54.173.116.19:3000")
@RequestMapping("/rental")
public class CarRentalController {
    @Autowired
    private CarRentalRepository carRentalRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/current")
    public ResponseEntity<List<CarRental>> getCurrentRental() {
        List<CarRental> carRentalList = carRentalRepository.findAllByEndDateGreaterThan(new Date());

        return ResponseEntity.ok().body(carRentalList);
    }

    @GetMapping("/finished")
    public ResponseEntity<List<CarRental>> getFinishedRental() {
        List<CarRental> carRentalList = carRentalRepository.findAllByEndDateLessThan(new Date());

        return ResponseEntity.ok().body(carRentalList);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarRental>> getAllRental() {
        List<CarRental> carRentalList = carRentalRepository.findAll();

        return ResponseEntity.ok().body(carRentalList);
    }

    @GetMapping()
    public ResponseEntity<CarRental> getRental(@RequestParam Integer id) {
        Optional<CarRental> carRental = carRentalRepository.findById(id);

        if (carRental.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(carRental.get());
    }

    @PostMapping
    public ResponseEntity<CarRental> newRental(@RequestBody RegisterDTO registerDTO) {
        Optional<Client> client = clientRepository.findOneById(registerDTO.client_id());
        Optional<Car> car = carRepository.findOneById(registerDTO.car_id());

        if (client.isEmpty() || car.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CarRental rental = carRentalRepository.save(new CarRental(registerDTO, client.get(), car.get()));
        return ResponseEntity.status(201).body(rental);
    }

    @PutMapping
    public ResponseEntity<CarRental> editRental(@RequestBody RegisterDTO registerDTO, @RequestParam Integer id) {
        Optional<CarRental> carRental = carRentalRepository.findOneById(id);

        if (carRental.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        CarRental newCarRental = carRentalRepository
                .save(new CarRental(id, registerDTO, carRental.get().getClient(), carRental.get().getCar()));
        return ResponseEntity.ok().body(newCarRental);
    }

    @DeleteMapping
    public ResponseEntity<CarRental> deleteRental(@RequestParam Integer id) {
        Optional<CarRental> carRental = carRentalRepository.findOneById(id);

        if (carRental.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        carRentalRepository.deleteById(id);
        return ResponseEntity.ok().body(carRental.get());
    }
}
