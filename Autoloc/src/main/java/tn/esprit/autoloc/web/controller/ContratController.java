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
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    // http://localhost:8085/contrat/retrieve-all-contrats
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> retrieveAllContrats() {
        return contratService.getAll();
    }

    // http://localhost:8085/contrat/retrieve-contrat/1
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        return contratService.getById(contratId);
    }

    // http://localhost:8085/contrat/add-contrat
    @PostMapping("/add-contrat")
    @ResponseStatus(HttpStatus.CREATED)
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.add(contrat);
    }

    // http://localhost:8085/contrat/modify-contrat
    @PutMapping("/modify-contrat")
    public Contrat modifyContrat(@RequestBody Contrat contrat) {
        return contratService.update(contrat);
    }

    // http://localhost:8085/contrat/remove-contrat/1
    @DeleteMapping("/remove-contrat/{contrat-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.delete(contratId);
    }
}
