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
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipement")
public class EquipementController {

    private final IEquipementService equipementService;

    public EquipementController(IEquipementService equipementService) {
        this.equipementService = equipementService;
    }

    // http://localhost:8085/equipement/retrieve-all-equipements
    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> retrieveAllEquipements() {
        return equipementService.getAll();
    }

    // http://localhost:8085/equipement/retrieve-equipement/1
    @GetMapping("/retrieve-equipement/{equipement-id}")
    public Equipement retrieveEquipement(@PathVariable("equipement-id") Long equipementId) {
        return equipementService.getById(equipementId);
    }

    // http://localhost:8085/equipement/add-equipement
    @PostMapping("/add-equipement")
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.add(equipement);
    }

    // http://localhost:8085/equipement/modify-equipement
    @PutMapping("/modify-equipement")
    public Equipement modifyEquipement(@RequestBody Equipement equipement) {
        return equipementService.update(equipement);
    }

    // http://localhost:8085/equipement/remove-equipement/1
    @DeleteMapping("/remove-equipement/{equipement-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEquipement(@PathVariable("equipement-id") Long equipementId) {
        equipementService.delete(equipementId);
    }
}
