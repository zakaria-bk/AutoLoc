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
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiement")
public class PaiementController {

    private final IPaiementService paiementService;

    public PaiementController(IPaiementService paiementService) {
        this.paiementService = paiementService;
    }

    // http://localhost:8085/paiement/retrieve-all-paiements
    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> retrieveAllPaiements() {
        return paiementService.getAll();
    }

    // http://localhost:8085/paiement/retrieve-paiement/1
    @GetMapping("/retrieve-paiement/{paiement-id}")
    public Paiement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
        return paiementService.getById(paiementId);
    }

    // http://localhost:8085/paiement/add-paiement
    @PostMapping("/add-paiement")
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.add(paiement);
    }

    // http://localhost:8085/paiement/modify-paiement
    @PutMapping("/modify-paiement")
    public Paiement modifyPaiement(@RequestBody Paiement paiement) {
        return paiementService.update(paiement);
    }

    // http://localhost:8085/paiement/remove-paiement/1
    @DeleteMapping("/remove-paiement/{paiement-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePaiement(@PathVariable("paiement-id") Long paiementId) {
        paiementService.delete(paiementId);
    }
}
