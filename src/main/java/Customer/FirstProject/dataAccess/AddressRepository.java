package Customer.FirstProject.dataAccess;

import Customer.FirstProject.entities.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    boolean existsByAddressId(int addressId);

}
