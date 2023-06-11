package eduardo.sinc.domain.client;

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

@Table(name = "client")
@Entity(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1, initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String cpf;

    public Client(ClientDTO clientDTO) {
        this.name = clientDTO.name();
        this.phone = clientDTO.phone();
        this.email = clientDTO.email();
        this.cpf = clientDTO.cpf();
    }

    public Client(Integer id, ClientDTO clientDTO) {
        this.id = id;
        this.name = clientDTO.name();
        this.phone = clientDTO.phone();
        this.email = clientDTO.email();
        this.cpf = clientDTO.cpf();
    }
}
