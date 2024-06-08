package soliq.task.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import soliq.task.exception.NegativeTransferAmountException;
import soliq.task.exception.NotFoundException;
import soliq.task.exception.ZeroTransferAmountException;
import soliq.task.model.entity.CommunalPaymentEntity;
import soliq.task.repository.CommunalPaymentRepository;
import soliq.task.service.CommunalPaymentService;

@Service
public class CommunalPaymentServiceImpl implements CommunalPaymentService {
    
    private final CommunalPaymentRepository communalPaymentRepository;
    
    public CommunalPaymentServiceImpl(CommunalPaymentRepository communalPaymentRepository) {
        
        this.communalPaymentRepository = communalPaymentRepository;
    }
    
    @Transactional
    @Override
    public void topUp(String title, String userPassportNumber, long amount) {
        
        if (amount == 0L) {
            throw new ZeroTransferAmountException("Amount to transfer is 0");
        } else if (amount < 0L) {
            throw new NegativeTransferAmountException("Amount to transfer is negative (" + amount + ")");
        }
        
        CommunalPaymentEntity user = communalPaymentRepository.findByTitleAndUserPassportNumber(title,
            userPassportNumber).orElseThrow(() -> new NotFoundException(
            "User with such passport " + userPassportNumber + " and such service " + title + " not found"));
        
        long newBalance = user.getBalance() + amount;
        user.setBalance(newBalance);
    }
    
}
