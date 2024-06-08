package soliq.task.service;

public interface CardService {
    
    void transferFunds(long senderCardNumber, long receiverCardNumber, long amount);
    
}
