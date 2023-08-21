package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.contact.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumberEntity, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
