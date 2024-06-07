package soliq.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soliq.task.model.entity.CardEntity;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
    
    Optional<CardEntity> findByNumber(long number);
    
}
