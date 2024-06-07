package soliq.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soliq.task.model.entity.ClientEntity;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Optional<ClientEntity> findByPassportNumber(String passportNumber);
    
}
