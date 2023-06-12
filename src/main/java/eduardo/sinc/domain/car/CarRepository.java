package eduardo.sinc.domain.car;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByPlate(String plate);

    List<Car> findByPlateOrModelOrBrand(String plate, String model, String brand);

    Optional<Car> findOneById(Integer id);
}
