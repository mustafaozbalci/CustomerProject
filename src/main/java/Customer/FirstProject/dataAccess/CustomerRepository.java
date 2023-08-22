package Customer.FirstProject.dataAccess;

import Customer.FirstProject.entities.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    boolean existsByCustomerId(int id);
    boolean existsByCustomerTC(String TC);

    @Override
    void deleteById(Integer integer);
}
