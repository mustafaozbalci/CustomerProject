package Deneme2.Second.service;

import Deneme2.Second.serviceAbstracts.CustomerService;
import Deneme2.Second.entities.customer.Customer;
import Deneme2.Second.requests.CreateCustomerRequest;
import Deneme2.Second.requests.UpdateCustomerRequest;
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
    public Customer addCustomer(CreateCustomerRequest createCustomerRequest) {
        if (checkIfTCExists(createCustomerRequest.getCustomerTC())) {
            throw new RuntimeException("This TC " + createCustomerRequest.getCustomerTC() + " Already Exists");
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(createCustomerRequest, customer);
        return customerRepository.save(customer);
    }




    public void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest) {
        Customer existingCustomer = getById(customerId);

        if (existingCustomer != null) {
            customerMapper.updateCustomerFromRequest(updateCustomerRequest, existingCustomer);
            customerRepository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public Customer getById(int id) {
        return customerRepository.findById(id).orElse(null);
    }
    public void delete(int id) {
        if (customerRepository.existsById(id)) {
            Customer customerToDelete = getById(id);
            customerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }


    public Customer getACustomer(){
        Customer customer = customerRepository.getOne(getACustomer().getCustomerId());
        return customer;
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
