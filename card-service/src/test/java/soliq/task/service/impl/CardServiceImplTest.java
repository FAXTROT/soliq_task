package soliq.task.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import soliq.task.exception.*;
import soliq.task.model.entity.CardEntity;
import soliq.task.repository.CardRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CardServiceImplTest {
    
    @Mock
    private CardRepository cardRepositoryMock;
    
    @Mock
    private CardEntity senderCardEntityMock;
    
    @Mock
    private CardEntity receiverCardEntityMock;
    
    @InjectMocks
    private CardServiceImpl cardService;
    
    private final long ZERO_BALANCE_CARD_NUMBER = 8600123456781234L;
    private final long LOW_BALANCE_CARD_NUMBER = 8600111456781234L;
    private final long BIG_BALANCE_CARD_NUMBER = 8600111456781554L;
    
    private final long ZERO_BALANCE_CARD_BALANCE = 0L;
    private final long LOW_BALANCE_CARD_BALANCE = 110L;
    private final long BIG_BALANCE_CARD_BALANCE = 57495437985L;
    
    private final long POSITIVE_AMOUNT = 234909L;
    private final long NEGATIVE_AMOUNT = -234909L;
    
    @Test
    void TransferFunds_WhenBalanceIsEnough_ShouldSaveNewBalances() {
        
        when(senderCardEntityMock.getBalance()).thenReturn(BIG_BALANCE_CARD_BALANCE);
        
        when(receiverCardEntityMock.getBalance()).thenReturn(ZERO_BALANCE_CARD_BALANCE);
        
        when(cardRepositoryMock.findByNumber(BIG_BALANCE_CARD_NUMBER)).thenReturn(Optional.of(senderCardEntityMock));
        when(cardRepositoryMock.findByNumber(ZERO_BALANCE_CARD_NUMBER)).thenReturn(Optional.of(receiverCardEntityMock));
        
        cardService.transferFunds(BIG_BALANCE_CARD_NUMBER, ZERO_BALANCE_CARD_NUMBER, POSITIVE_AMOUNT);
        
        verify(senderCardEntityMock, times(1))
            .setBalance(senderCardEntityMock.getBalance() - POSITIVE_AMOUNT);
        
        verify(receiverCardEntityMock, times(1))
            .setBalance(receiverCardEntityMock.getBalance() + POSITIVE_AMOUNT);
        
    }
    
    @Test
    void TransferFunds_WhenBalanceIsNotEnough_ShouldThrowException() {
        
        when(senderCardEntityMock.getBalance()).thenReturn(LOW_BALANCE_CARD_BALANCE);
        
        when(cardRepositoryMock.findByNumber(LOW_BALANCE_CARD_NUMBER)).thenReturn(Optional.of(senderCardEntityMock));
        when(cardRepositoryMock.findByNumber(ZERO_BALANCE_CARD_NUMBER)).thenReturn(Optional.of(receiverCardEntityMock));
        
        assertThrows(LowBalanceException.class,
            () -> {
                cardService.transferFunds(LOW_BALANCE_CARD_NUMBER, ZERO_BALANCE_CARD_NUMBER, POSITIVE_AMOUNT);
            });
        
    }
    
    @Test
    void TransferFunds_WhenAmountIsNegative_ShouldThrowException() {
        
        assertThrows(NegativeTransferAmountException.class,
            () -> {
                cardService.transferFunds(LOW_BALANCE_CARD_NUMBER, ZERO_BALANCE_CARD_NUMBER, NEGATIVE_AMOUNT);
            });
        
    }
    
    @Test
    void TransferFunds_WhenAmountIsZero_ShouldThrowException() {
        
        assertThrows(ZeroTransferAmountException.class,
            () -> {
                cardService.transferFunds(LOW_BALANCE_CARD_NUMBER, ZERO_BALANCE_CARD_NUMBER, ZERO_BALANCE_CARD_BALANCE);
            });
        
    }
    
    @Test
    void TransferFunds_WhenSenderCardNotFound_ShouldThrowException() {
        
        assertThrows(NotFoundException.class,
            () -> {
                cardService.transferFunds(LOW_BALANCE_CARD_NUMBER, ZERO_BALANCE_CARD_NUMBER, POSITIVE_AMOUNT);
            });
        
    }
    
    @Test
    void TransferFunds_WhenReceiverCardNotFound_ShouldThrowException() {
        
        when(cardRepositoryMock.findByNumber(LOW_BALANCE_CARD_NUMBER)).thenReturn(Optional.of(senderCardEntityMock));
        
        assertThrows(NotFoundException.class,
            () -> {
                cardService.transferFunds(LOW_BALANCE_CARD_NUMBER, ZERO_BALANCE_CARD_NUMBER, POSITIVE_AMOUNT);
            });
        
    }
    
    @Test
    void TransferFunds_WhenSelfTransfer_ShouldThrowException() {
        
        assertThrows(SelfTransferException.class,
            () -> {
                cardService.transferFunds(LOW_BALANCE_CARD_NUMBER, LOW_BALANCE_CARD_NUMBER, POSITIVE_AMOUNT);
            });
        
    }
    
}
