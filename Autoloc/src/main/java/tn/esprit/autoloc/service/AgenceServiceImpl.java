package tn.esprit.autoloc.service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;

import java.util.List;

@Service
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    public AgenceServiceImpl(IAgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence add(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence update(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void delete(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    public Agence getById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable avec l'id : " + id));
    }
    @Override
    public List<Agence> getAll() {
        return agenceRepository.findAll();
    }
}
