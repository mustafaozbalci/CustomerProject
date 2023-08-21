package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    boolean existsByAddressId(int addressId);

}
