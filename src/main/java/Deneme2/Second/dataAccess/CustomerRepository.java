package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByCustomerId(int id);
    boolean existsByCustomerTC(String TC);

    @Override
    void deleteById(Integer integer);
}
