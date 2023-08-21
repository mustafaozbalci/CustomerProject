package Deneme2.Second.Serviceabstracts;

import Deneme2.Second.entities.customer.Customer;
import Deneme2.Second.requests.CreateCustomerRequest;
import Deneme2.Second.requests.UpdateCustomerRequest;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService{

    public Customer getACustomer();
    public Customer addCustomer(CreateCustomerRequest createCustomerRequest);
    public  Customer getById(int id);
    public  void updateCustomer (int customerId, UpdateCustomerRequest updateCustomerRequest);
    public  void delete (int id);




}
