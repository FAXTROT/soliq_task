package soliq.task.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soliq.task.exception.*;
import soliq.task.model.entity.CardEntity;
import soliq.task.repository.CardRepository;
import soliq.task.service.CardService;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    
    private final CardRepository cardRepository;
    
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    
    @Transactional
    @Override
    public void transferFunds(long senderCardNumber, long receiverCardNumber, long amount) {
        
        if (amount == 0L) {
            throw new ZeroTransferAmountException("Amount to transfer is 0");
        } else if (amount < 0L) {
            throw new NegativeTransferAmountException("Amount to transfer is negative (" + amount + ")");
        } else if (senderCardNumber == receiverCardNumber) {
            throw new SelfTransferException("Can not transfer to itself");
        }
        
        CardEntity sender = cardRepository.findByNumber(senderCardNumber)
            .orElseThrow(() -> new NotFoundException("Card with number " + senderCardNumber + " not found"));
        
        CardEntity receiver = cardRepository.findByNumber(receiverCardNumber)
            .orElseThrow(() -> new NotFoundException("Card with number " + receiverCardNumber + " not found"));
        
        long senderNewBalance = sender.getBalance() - amount;
        if (senderNewBalance < 0) {
            throw new LowBalanceException(
                "Low balance ! Sender`s balance = " + sender.getBalance() + "; amount to transfer = " + amount);
        }
        
        long receiverNewBalance = receiver.getBalance() + amount;
        
        sender.setBalance(senderNewBalance);
        receiver.setBalance(receiverNewBalance);
        
    }
    
}
