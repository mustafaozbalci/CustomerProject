package Customer.FirstProject.dataAccess;

import Customer.FirstProject.entities.contact.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumberEntity, Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
