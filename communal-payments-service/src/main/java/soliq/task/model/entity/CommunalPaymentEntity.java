package soliq.task.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import soliq.task.model.entity.ids.CommunalPaymentEntityId;

import java.io.Serializable;


@Getter
@Setter
@Entity
@IdClass(CommunalPaymentEntityId.class)
@Table(name = "communal_payment")
public class CommunalPaymentEntity implements Serializable {
    
    @Id
    @Column(name = "title")
    private String title;
    
    @Id
    @Column(name = "userPassportNumber")
    private String userPassportNumber;
    
    @Column(name = "balance")
    private long balance;
    
}
