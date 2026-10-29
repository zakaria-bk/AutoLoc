package tn.esprit.autoloc.service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;
import java.util.List;
@Service
public class EmployeServiceImpl implements IEmployeService {

    private final IEmployeRepository employeRepository;

    public EmployeServiceImpl(IEmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public Employe add(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe update(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void delete(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe getById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable avec l'id : " + id));
    }
    @Override
    public List<Employe> getAll() {
        return employeRepository.findAll();
    }
}
