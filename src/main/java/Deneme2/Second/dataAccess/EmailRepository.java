package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.contact.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Integer> {
    boolean existsByEmailAddress(String emailAddress);
    boolean existsByEmailId(int emailId);
}
