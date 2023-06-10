package eduardo.sinc.domain.car;

import java.sql.Date;

public record CarDTO(String plate, String model, String brand, double current_km, Date vehicle_year) {
}
