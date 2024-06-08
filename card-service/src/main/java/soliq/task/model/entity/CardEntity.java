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
@Table(name = "card")
public class CardEntity {
    
    
    @Id
    @Column(name = "number")
    private long number;
    
    @Column(name = "holders_passport_number")
    private String holdersPassportNumber;
    
    @Column(name = "balance")
    private long balance;
    
    public CardEntity() {
        // default constructor
    }
    
    public CardEntity(long number, String holdersPassportNumber, long balance) {
        this.number = number;
        this.holdersPassportNumber = holdersPassportNumber;
        this.balance = balance;
    }
    
}
