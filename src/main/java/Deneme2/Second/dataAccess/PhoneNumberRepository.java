package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.contact.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
