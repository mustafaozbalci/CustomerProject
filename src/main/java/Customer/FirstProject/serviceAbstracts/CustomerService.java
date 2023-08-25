package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.CustomerDto;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import org.springframework.stereotype.Service;


public interface CustomerService {
    void createCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(int id);

    void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest);

    void delete(int id);



}
