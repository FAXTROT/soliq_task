package soliq.task.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class ClientEntity {
    
    @Id
    @Column(name = "passport_number")
    private String passportNumber;
    
    @Column(name = "full_name")
    private String fullName;
    
}
