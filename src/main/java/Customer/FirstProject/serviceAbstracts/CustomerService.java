package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.entities.customer.CustomerEntity;
import Customer.FirstProject.requests.Create.CreateCustomerRequest;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerEntity getACustomer();

    CustomerEntity addCustomer(CreateCustomerRequest createCustomerRequest);

    CustomerEntity getById(int id);

    void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest);

    void delete(int id);


}
