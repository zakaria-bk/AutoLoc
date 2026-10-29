package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IMaintenanceRepository;
import tn.esprit.autoloc.repository.IVehiculeRepository;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;
    private final IVehiculeRepository vehiculeRepository;

    public MaintenanceServiceImpl(IMaintenanceRepository maintenanceRepository,
                                  IVehiculeRepository vehiculeRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    @Transactional
    public Maintenance add(Maintenance maintenance) {
        Vehicule vehicule = maintenance.getVehicule();
        if (vehicule != null && vehicule.getIdVehicule() != null) {
            // Maintenance -> Vehicule has cascade PERSIST: the vehicle must be a managed entity
            maintenance.setVehicule(vehiculeRepository.findById(vehicule.getIdVehicule())
                    .orElseThrow(() -> new EntityNotFoundException(
                            "Vehicule introuvable avec l'id : " + vehicule.getIdVehicule())));
        }
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance update(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void delete(Long id) {
        maintenanceRepository.deleteById(id);
    }

    @Override
    public Maintenance getById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable avec l'id : " + id));
    }

    @Override
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }
}
