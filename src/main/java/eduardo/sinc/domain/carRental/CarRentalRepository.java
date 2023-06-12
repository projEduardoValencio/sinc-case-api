package eduardo.sinc.domain.carRental;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRentalRepository extends JpaRepository<CarRental, Integer> {
    public List<CarRental> findAllByEndDateLessThan(Date today);

    public List<CarRental> findAllByEndDateGreaterThan(Date today);

    public Optional<CarRental> findOneById(Integer id);

}
