package eduardo.sinc.domain.client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findByCpf(String cpf);
}
