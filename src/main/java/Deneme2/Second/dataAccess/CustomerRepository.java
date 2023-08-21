package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    boolean existsByCustomerId(int id);
    boolean existsByCustomerTC(String TC);

    @Override
    void deleteById(Integer integer);
}
