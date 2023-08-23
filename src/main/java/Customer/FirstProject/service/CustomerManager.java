package Customer.FirstProject.service;

import Customer.FirstProject.dataAccess.AddressRepository;
import Customer.FirstProject.dataAccess.CustomerRepository;
import Customer.FirstProject.entities.customer.CustomerEntity;
import Customer.FirstProject.mapper.CustomerMapper;
import Customer.FirstProject.requests.Create.CreateCustomerRequest;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import Customer.FirstProject.serviceAbstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@RequiredArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressRepository addressRepository;


    public CustomerEntity createCustomer(CustomerEntity customerEntity){
        return customerRepository.save(customerEntity);
    }




    public void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest) {
        CustomerEntity existingCustomerEntity = getById(customerId);

        if (existingCustomerEntity != null) {
            customerMapper.updateCustomerFromRequest(updateCustomerRequest, existingCustomerEntity);
            customerRepository.save(existingCustomerEntity);
        } else {
            throw new RuntimeException("CustomerEntity not found");
        }
    }

    public CustomerEntity getById(int id) {
        return customerRepository.findById(id).orElse(null);
    }
    public void delete(int id) {
        if (customerRepository.existsById(id)) {
            CustomerEntity customerEntityToDelete = getById(id);
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("CustomerEntity not found");
        }
    }


    public CustomerEntity getACustomer(){
        CustomerEntity customerEntity = customerRepository.getOne(getACustomer().getCustomerId());
        return customerEntity;
    }
    public boolean checkIfIdExists(int id){
        if(customerRepository.existsById(id))
            return true;
        else {
            return false;
        }
    }
}
