package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.CustomerDto;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;


public interface CustomerService {
    void createCustomer(CustomerDto customerDto);

    CustomerDto getCustomer(int customerId);

    void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest);

    void deleteCustomer(int customerId);


}
