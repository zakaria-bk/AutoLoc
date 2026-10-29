package tn.esprit.autoloc.service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;
import java.util.List;
@Service
public class ContratServiceImpl implements IContratService {

    private final IContratRepository contratRepository;

    public ContratServiceImpl(IContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public Contrat add(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void delete(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat getById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable avec l'id : " + id));
    }
    @Override
    public List<Contrat> getAll() {
        return contratRepository.findAll();
    }
}
