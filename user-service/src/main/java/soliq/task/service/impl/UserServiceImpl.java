package soliq.task.service.impl;

import org.springframework.stereotype.Service;
import soliq.task.exception.EntityNotFoundException;
import soliq.task.model.dto.UserDTO;
import soliq.task.model.entity.UserEntity;
import soliq.task.model.mapper.UserMapper;
import soliq.task.repository.UserRepository;
import soliq.task.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    private UserMapper userMapper = new UserMapper();
    
    private final UserRepository userRepository;
    
    public UserServiceImpl(UserRepository userRepository) {
        
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDTO getByPassportNumber(String passportNumber) {
        
        UserEntity userEntity = userRepository.findByPassportNumber(passportNumber)
            .orElseThrow(() -> new EntityNotFoundException("User with passport " + passportNumber + " not found"));
        return userMapper.convertToDto(userEntity);
    }
    
}
