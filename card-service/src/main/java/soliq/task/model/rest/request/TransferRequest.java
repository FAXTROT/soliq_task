package soliq.task.model.rest.request;

import lombok.Data;

@Data
public class TransferRequest {
    
    private Long senderCardNumber;
    
    private Long receiverCardNumber;
    
    private Long amount;
    
    public TransferRequest(Long senderCardNumber, Long receiverCardNumber, Long amount) {
        
        this.senderCardNumber = senderCardNumber;
        this.receiverCardNumber = receiverCardNumber;
        this.amount = amount;
    }
    
}
