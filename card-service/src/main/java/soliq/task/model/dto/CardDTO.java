package soliq.task.model.dto;

import lombok.Data;

@Data
public class CardDTO {
    
    private long number;
    
    private String holdersPassportNumber;
    
    private long balance;
    
}
