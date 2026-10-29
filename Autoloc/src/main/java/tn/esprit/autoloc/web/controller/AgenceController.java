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
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agence")
public class AgenceController {

    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    // http://localhost:8085/agence/retrieve-all-agences
    @GetMapping("/retrieve-all-agences")
    public List<Agence> retrieveAllAgences() {
        return agenceService.getAll();
    }

    // http://localhost:8085/agence/retrieve-agence/1
    @GetMapping("/retrieve-agence/{agence-id}")
    public Agence retrieveAgence(@PathVariable("agence-id") Long agenceId) {
        return agenceService.getById(agenceId);
    }

    // http://localhost:8085/agence/add-agence
    @PostMapping("/add-agence")
    @ResponseStatus(HttpStatus.CREATED)
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.add(agence);
    }

    // http://localhost:8085/agence/modify-agence
    @PutMapping("/modify-agence")
    public Agence modifyAgence(@RequestBody Agence agence) {
        return agenceService.update(agence);
    }

    // http://localhost:8085/agence/remove-agence/1
    @DeleteMapping("/remove-agence/{agence-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAgence(@PathVariable("agence-id") Long agenceId) {
        agenceService.delete(agenceId);
    }
}
