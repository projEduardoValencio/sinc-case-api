package eduardo.sinc.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByPlate(String plate);

    List<Car> findByPlateOrModelOrBrand(String plate, String model, String brand);
}
