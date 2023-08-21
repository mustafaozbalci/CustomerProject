package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.contact.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
    boolean existsByEmailAddress(String emailAddress);
    boolean existsByEmailId(int emailId);
}
