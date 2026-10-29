package tn.esprit.autoloc.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    // http://localhost:8085/client/retrieve-all-clients
    @GetMapping("/retrieve-all-clients")
    public List<Client> retrieveAllClients() {
        return clientService.getAll();
    }

    // http://localhost:8085/client/retrieve-client/1
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.getById(clientId);
    }

    // http://localhost:8085/client/add-client
    @PostMapping("/add-client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@RequestBody Client client) {
        return clientService.add(client);
    }

    // http://localhost:8085/client/modify-client
    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client client) {
        return clientService.update(client);
    }

    // http://localhost:8085/client/remove-client/1
    @DeleteMapping("/remove-client/{client-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.delete(clientId);
    }
}
