package soliq.task.model.rest.request;

import lombok.Data;

@Data
public class TopUpRequest {
    
    private String title;
    
    private String userPassportNumber;
    
    private Long amount;
    
    public TopUpRequest(String title, String userPassportNumber, Long amount) {
        
        this.title = title;
        this.userPassportNumber = userPassportNumber;
        this.amount = amount;
        
    }
    
}
