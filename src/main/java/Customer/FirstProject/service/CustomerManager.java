package Customer.FirstProject.service;

import Customer.FirstProject.Dto.CustomerDto;
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
    private final LogServiceImp logService;


    public void createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerDto);
        customerRepository.save(customerEntity);
        String successMessage = "Customer : " + customerEntity + " Created Successfully";
        logService.saveLog(successMessage);
    }


    public CustomerDto getCustomer(int customerId) {
        CustomerEntity customerEntity = customerRepository.findById(customerId).orElse(null);
        if (customerEntity == null) {
            String errorMessage = "CustomerEntity ID : " + customerId + " Not Found!, GetMapping Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return customerMapper.toDto(customerEntity);
    }


    public void deleteCustomer(int customerId) {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            String successMessage = "CustomerEntity ID :  " + customerId + " Deleted Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "CustomerEntity ID : " + customerId + " Not Found!, Delete Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest) {
        CustomerEntity existingCustomerEntity = customerMapper.toEntity(getCustomer(customerId));
        if (existingCustomerEntity != null) {
            customerMapper.UpdateCustomerFromRequest(updateCustomerRequest, existingCustomerEntity);
            customerRepository.save(existingCustomerEntity);
            String successMessage = "CustomerEntity ID : " + customerId + " Updated Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "CustomerEntity ID : " + customerId + " Not Found!, Update Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }
}
