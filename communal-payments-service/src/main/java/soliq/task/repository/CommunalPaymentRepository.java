package soliq.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soliq.task.model.entity.CommunalPaymentEntity;
import soliq.task.model.entity.ids.CommunalPaymentEntityId;

import java.util.Optional;

@Repository
public interface CommunalPaymentRepository extends JpaRepository<CommunalPaymentEntity, CommunalPaymentEntityId> {
    
    Optional<CommunalPaymentEntity> findByTitleAndUserPassportNumber(String title, String userPassportNumber);
    
}
