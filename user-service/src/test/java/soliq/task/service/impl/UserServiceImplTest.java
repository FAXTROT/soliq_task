package soliq.task.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soliq.task.exception.EntityNotFoundException;
import soliq.task.model.entity.UserEntity;
import soliq.task.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserServiceImpl userService;
    
    private String EXISTING_CLIENT_PASSPORT_NUMBER_1 = "DD1230987";
    
    private String EXISTING_CLIENT_FULL_NAME_1 = "Test Full Name";
    
    private String NOT_EXISTING_CLIENT_PASSPORT_NUMBER = "DD1110987";
    
    @Test
    void GetByPassportNumber_WhenExists_ShouldGiveUserDTO() {
        
        UserEntity userEntity = new UserEntity();
        userEntity.setPassportNumber(EXISTING_CLIENT_PASSPORT_NUMBER_1);
        userEntity.setFullName(EXISTING_CLIENT_FULL_NAME_1);
        
        when(userRepository.findByPassportNumber(EXISTING_CLIENT_PASSPORT_NUMBER_1)).thenReturn(Optional.of(userEntity));
        
        userService.getByPassportNumber(EXISTING_CLIENT_PASSPORT_NUMBER_1);
        verify(userRepository, times(1)).findByPassportNumber(EXISTING_CLIENT_PASSPORT_NUMBER_1);
    }
    
    @Test
    void GetByPassportNumber_WhenNotExists_ShouldThrowException() {
        
        assertThrows(EntityNotFoundException.class,
            () -> {
                userService.getByPassportNumber(NOT_EXISTING_CLIENT_PASSPORT_NUMBER);
            });
    }
    
}
