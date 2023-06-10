package sinc.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {
    @GetMapping
    public ResponseEntity<String> getAllCars() {
        return ResponseEntity.status(200).body("OK");
    }
}
