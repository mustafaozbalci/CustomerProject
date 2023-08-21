package Deneme2.Second.serviceAbstracts;

import Deneme2.Second.entities.customer.CustomerEntity;
import Deneme2.Second.requests.Create.CreateCustomerRequest;
import Deneme2.Second.requests.Update.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    CustomerEntity getACustomer();

    CustomerEntity addCustomer(CreateCustomerRequest createCustomerRequest);

    CustomerEntity getById(int id);

    void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest);

    void delete(int id);


}
