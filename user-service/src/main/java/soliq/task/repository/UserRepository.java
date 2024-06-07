package soliq.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soliq.task.model.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    Optional<UserEntity> findByPassportNumber(String passportNumber);
    
}
