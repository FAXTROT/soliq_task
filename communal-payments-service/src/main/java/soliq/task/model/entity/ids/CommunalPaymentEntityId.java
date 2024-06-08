package soliq.task.model.entity.ids;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CommunalPaymentEntityId implements Serializable {
    
    private String title;
    
    private String userPassportNumber;
    
    public CommunalPaymentEntityId() {
    
    }
    
    public CommunalPaymentEntityId(String title, String userPassportNumber) {
        this.title = title;
        this.userPassportNumber = userPassportNumber;
    }
    
}
