package Deneme2.Second.service;

import Deneme2.Second.entities.customer.CustomerEntity;
import Deneme2.Second.serviceAbstracts.CustomerService;
import Deneme2.Second.requests.Create.CreateCustomerRequest;
import Deneme2.Second.requests.Update.UpdateCustomerRequest;
import Deneme2.Second.dataAccess.AddressRepository;
import Deneme2.Second.dataAccess.CustomerRepository;
import Deneme2.Second.mapper.CustomerMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    private AddressRepository addressRepository;

    public CustomerManager(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }
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
