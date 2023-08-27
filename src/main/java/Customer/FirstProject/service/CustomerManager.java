package Customer.FirstProject.service;

import Customer.FirstProject.Dto.CustomerDto;
import Customer.FirstProject.dataAccess.AddressRepository;
import Customer.FirstProject.dataAccess.CustomerRepository;
import Customer.FirstProject.entities.customer.CustomerEntity;
import Customer.FirstProject.mapper.CustomerMapper;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import Customer.FirstProject.serviceAbstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressRepository addressRepository;


    public void createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerDto);
        customerRepository.save(customerEntity);
        System.out.println("Customer : " + customerEntity + " Created Successfully");
    }


    public CustomerDto getCustomer(int customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElse(null);
        if(customerEntity == null)
            throw new RuntimeException("CustomerEntity ID : " + customerId + " Not Found!");
        return customerMapper.toDto(customerEntity);
    }


    public void deleteCustomer(int customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            System.out.println("CustomerEntity ID :  " + customerId + " Deleted Successfully");
        } else {
            throw new RuntimeException("CustomerEntity ID : " + customerId + " Not Found!");
        }
    }

    public void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest) {
        CustomerEntity existingCustomerEntity = customerMapper.toEntity(getCustomer(customerId));
        if (existingCustomerEntity != null) {
            customerMapper.UpdateCustomerFromRequest(updateCustomerRequest, existingCustomerEntity);
            customerRepository.save(existingCustomerEntity);
            System.out.println("CustomerEntity ID : " + customerId + " Updated Successfully");
        } else {
            throw new RuntimeException("CustomerEntity ID : " + customerId + " Not Found!, Update failed ");
        }
    }
}
