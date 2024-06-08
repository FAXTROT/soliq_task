package soliq.task.service;

public interface CommunalPaymentService {
    
    void topUp(String title, String userPassportNumber, long amount);
    
}
