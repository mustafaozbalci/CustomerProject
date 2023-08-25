package Customer.FirstProject.service;

import Customer.FirstProject.Dto.CustomerDto;
import Customer.FirstProject.dataAccess.AddressRepository;
import Customer.FirstProject.dataAccess.CustomerRepository;
import Customer.FirstProject.entities.customer.CustomerEntity;
import Customer.FirstProject.mapper.CustomerMapper;
import Customer.FirstProject.serviceAbstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressRepository addressRepository;


    public void createCustomer(CustomerDto customerDto){
        CustomerEntity customerEntity = customerMapper.toEntity(customerDto);
        customerRepository.save(customerEntity);
        System.out.println("Customer : " + customerEntity + " Created Successfully");
    }


    public CustomerDto getCustomer(int id) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElse(null);
        return customerMapper.toDto(customerEntity);
    }

//    public void updateCustomer(int customerId, UpdateCustomerRequest updateCustomerRequest) {
//        CustomerEntity existingCustomerEntity = getById(customerId);
//
//        if (existingCustomerEntity != null) {
//            customerMapper.updateCustomerFromRequest(updateCustomerRequest, existingCustomerEntity);
//            customerRepository.save(existingCustomerEntity);
//        } else {
//            throw new RuntimeException("CustomerEntity not found");
//        }
//    }


//    public void delete(int id) {
//        if (customerRepository.existsById(id)) {
//            CustomerEntity customerEntityToDelete = getById(id);
//            customerRepository.deleteById(id);
//        } else {
//            throw new RuntimeException("CustomerEntity not found");
//        }
//    }
//
//
//    public CustomerEntity getACustomer(){
//        CustomerEntity customerEntity = customerRepository.getOne(getACustomer().getCustomerId());
//        return customerEntity;
//    }
//    public boolean checkIfIdExists(int id){
//        if(customerRepository.existsById(id))
//            return true;
//        else {
//            return false;
//        }
//    }
}
