package soliq.task.service.impl;

import org.springframework.stereotype.Service;
import soliq.task.exception.EntityNotFoundException;
import soliq.task.model.dto.ClientDTO;
import soliq.task.model.entity.ClientEntity;
import soliq.task.model.mapper.ClientMapper;
import soliq.task.repository.ClientRepository;
import soliq.task.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientMapper clientMapper = new ClientMapper();
    private final ClientRepository clientRepository;
    
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public ClientDTO getByPassportNumber(String passportNumber) {
        ClientEntity clientEntity = clientRepository.findByPassportNumber(passportNumber)
            .orElseThrow(() -> new EntityNotFoundException("User with passport " + passportNumber + " not found"));
        return clientMapper.convertToDto(clientEntity);
    }
}
