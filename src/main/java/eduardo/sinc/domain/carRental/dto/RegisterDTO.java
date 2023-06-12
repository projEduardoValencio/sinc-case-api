package eduardo.sinc.domain.carRental.dto;

import java.util.Date;

public record RegisterDTO(Integer client_id, Integer car_id, Date start_date, Date end_date) {
}
