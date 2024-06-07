package soliq.task.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_acc")
public class UserEntity {
    
    @Id
    @Column(name = "passport_number")
    private String passportNumber;
    
    @Column(name = "full_name")
    private String fullName;
    
}
