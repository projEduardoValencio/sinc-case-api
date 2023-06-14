package eduardo.sinc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eduardo.sinc.domain.client.Client;
import eduardo.sinc.domain.client.ClientDTO;
import eduardo.sinc.domain.client.ClientRepository;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://54.173.116.19:3000")
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        var allClients = clientRepository.findAll();
        return ResponseEntity.status(200).body(allClients);
    }

    @GetMapping
    public ResponseEntity<List<Client>> searchClient(@RequestParam String cpf) {
        List<Client> client = clientRepository.findByCpf(cpf);
        if (client.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(200).body(client);
    }

    @PostMapping
    public ResponseEntity<Client> registerClient(@RequestBody @Valid @Validated ClientDTO data) {
        Client newClient = clientRepository.save(new Client(data));
        return ResponseEntity.status(201).body(newClient);
    }

    @PutMapping()
    public ResponseEntity<Client> updateClient(@RequestBody @Valid ClientDTO data, @RequestParam Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Client newClient = clientRepository.save(new Client(id, data));
        return ResponseEntity.ok(newClient);
    }

    @DeleteMapping
    public ResponseEntity<Client> deleteClient(@RequestParam Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        clientRepository.deleteById(id);
        return ResponseEntity.ok().body(client.get());
    }
}
