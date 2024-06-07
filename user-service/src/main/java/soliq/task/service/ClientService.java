package soliq.task.service;

import soliq.task.model.dto.ClientDTO;

public interface ClientService {
    
    ClientDTO getByPassportNumber(String passportNumber);
    
}
