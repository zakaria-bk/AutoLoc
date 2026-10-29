package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;

import java.util.List;

@Service
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(IVehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public Vehicule add(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule getById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable avec l'id : " + id));
    }

    @Override
    public List<Vehicule> getAll() {
        return vehiculeRepository.findAll();
    }
}
