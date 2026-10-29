package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;

import java.util.List;

@Service
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;

    public EquipementServiceImpl(IEquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement add(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement update(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void delete(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public Equipement getById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable avec l'id : " + id));
    }

    @Override
    public List<Equipement> getAll() {
        return equipementRepository.findAll();
    }
}
