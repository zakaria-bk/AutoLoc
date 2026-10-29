package tn.esprit.autoloc.service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClientRepository;
import java.util.List;
@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id : " + id));
    }
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
