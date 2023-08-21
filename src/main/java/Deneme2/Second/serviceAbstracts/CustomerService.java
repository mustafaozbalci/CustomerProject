package Deneme2.Second.serviceAbstracts;

import Deneme2.Second.entities.customer.Customer;
import Deneme2.Second.requests.Create.CreateCustomerRequest;
import Deneme2.Second.requests.Update.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService{

    public Customer getACustomer();
    public Customer addCustomer(CreateCustomerRequest createCustomerRequest);
    public  Customer getById(int id);
    public  void updateCustomer (int customerId, UpdateCustomerRequest updateCustomerRequest);
    public  void delete (int id);




}
