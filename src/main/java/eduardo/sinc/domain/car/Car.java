package eduardo.sinc.domain.car;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "car")
@Entity(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @EqualsAndHashCode(of = "id")
public class Car {
    @Id
    @SequenceGenerator(name = "car_id_seq", sequenceName = "car_id_seq", allocationSize = 1, initialValue = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq")
    private Integer id;
    private String plate;
    private String model;
    private String brand;
    private double current_km;
    private Date vehicle_year;

    public Car(CarDTO carDTO) {
        this.plate = carDTO.plate();
        this.model = carDTO.model();
        this.brand = carDTO.brand();
        this.current_km = carDTO.current_km();
        this.vehicle_year = carDTO.vehicle_year();
    }

    public Car(Integer id, CarDTO carDTO) {
        this.id = id;
        this.plate = carDTO.plate();
        this.model = carDTO.model();
        this.brand = carDTO.brand();
        this.current_km = carDTO.current_km();
        this.vehicle_year = carDTO.vehicle_year();
    }
}
