package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(IMaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance add(Maintenance maintenance) {
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
