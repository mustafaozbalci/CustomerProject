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
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    private AddressRepository addressRepository;


    @Transactional
    public CustomerEntity addCustomer(CreateCustomerRequest createCustomerRequest) {
        if (checkIfTCExists(createCustomerRequest.getCustomerTC())) {
            throw new RuntimeException("This TC " + createCustomerRequest.getCustomerTC() + " Already Exists");
        }

        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(createCustomerRequest, customerEntity);
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
    public boolean checkIfTCExists(String TC){
        if(customerRepository.existsByCustomerTC(TC))
            throw new RuntimeException("This TC " + TC + " Already Exists");
        return false;
    }
}
