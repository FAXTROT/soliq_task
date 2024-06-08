package soliq.task.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soliq.task.exception.*;
import soliq.task.model.entity.CommunalPaymentEntity;
import soliq.task.repository.CommunalPaymentRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommunalPaymentServiceImplTest {
    
    
    @Mock
    private CommunalPaymentRepository communalPaymentRepositoryMock;
    
    @Mock
    private CommunalPaymentEntity communalPaymentEntityMock;
    
    @InjectMocks
    private CommunalPaymentServiceImpl communalPaymentService;
    
    private final String TITLE_OF_MOCK_COMMUNAL_SERVICE = "Gas";
    
    private final String PASSPORT_OF_MOCK_USER = "AA1234567";
    
    private final long BALANCE = 100L;
    
    private final long POSITIVE_AMOUNT = 100L;
    
    private final long NEGATIVE_AMOUNT = -234909L;
    
    private final long ZERO_AMOUNT = 0L;
    
    @Test
    void TopUp_WhenNoIssues_ShouldTopUpBalance() {
        
        when(communalPaymentRepositoryMock.findByTitleAndUserPassportNumber(TITLE_OF_MOCK_COMMUNAL_SERVICE,
            PASSPORT_OF_MOCK_USER)).thenReturn(Optional.of(communalPaymentEntityMock));
        
        when(communalPaymentEntityMock.getBalance()).thenReturn(BALANCE);
        
        communalPaymentService.topUp(TITLE_OF_MOCK_COMMUNAL_SERVICE, PASSPORT_OF_MOCK_USER, POSITIVE_AMOUNT);
        
        verify(communalPaymentEntityMock, times(1)).setBalance(BALANCE + POSITIVE_AMOUNT);
        
    }
    
    @Test
    void TopUp_WhenAmountIsNegative_ShouldThrowException() {
        
        assertThrows(NegativeTransferAmountException.class,
            () -> {
                communalPaymentService.topUp(TITLE_OF_MOCK_COMMUNAL_SERVICE, PASSPORT_OF_MOCK_USER, NEGATIVE_AMOUNT);
            });
        
    }
    
    @Test
    void TopUp_WhenAmountIsZero_ShouldThrowException() {
        
        assertThrows(ZeroTransferAmountException.class,
            () -> {
                communalPaymentService.topUp(TITLE_OF_MOCK_COMMUNAL_SERVICE, PASSPORT_OF_MOCK_USER, ZERO_AMOUNT);
            });
        
    }
    
    @Test
    void TopUp_WhenUserNotFound_ShouldThrowException() {
        
        assertThrows(NotFoundException.class,
            () -> {
                communalPaymentService.topUp(TITLE_OF_MOCK_COMMUNAL_SERVICE, PASSPORT_OF_MOCK_USER, POSITIVE_AMOUNT);
            });
        
    }
    
}
