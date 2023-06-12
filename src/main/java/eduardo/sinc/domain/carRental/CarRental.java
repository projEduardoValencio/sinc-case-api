package eduardo.sinc.domain.carRental;

import java.util.Date;

import eduardo.sinc.domain.car.Car;
import eduardo.sinc.domain.carRental.dto.RegisterDTO;
import eduardo.sinc.domain.client.Client;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "car_rental")
@Entity(name = "car_rental")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarRental {
    @Id
    @SequenceGenerator(name = "car_rental_id_seq", sequenceName = "car_rental_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_rental_id_seq")
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    public CarRental(RegisterDTO registerDTO, Client client, Car car) {
        this.client = client;
        this.car = car;
        this.startDate = registerDTO.start_date();
        this.endDate = registerDTO.end_date();
    }

    public CarRental(Integer id, RegisterDTO registerDTO, Client client, Car car) {
        this.id = id;
        this.client = client;
        this.car = car;
        this.startDate = registerDTO.start_date();
        this.endDate = registerDTO.end_date();
    }
}
