package soliq.task.service;

import soliq.task.model.dto.UserDTO;

public interface UserService {
    
    UserDTO getByPassportNumber(String passportNumber);
    
}
