package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.IPaiementRepository;

import java.util.List;

@Service
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiementRepository paiementRepository;

    public PaiementServiceImpl(IPaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    @Override
    public Paiement add(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement update(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void delete(Long id) {
        paiementRepository.deleteById(id);
    }

    @Override
    public Paiement getById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable avec l'id : " + id));
    }

    @Override
    public List<Paiement> getAll() {
        return paiementRepository.findAll();
    }
}
