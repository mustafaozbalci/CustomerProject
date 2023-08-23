package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.CustomerDto;
import Customer.FirstProject.entities.customer.CustomerEntity;
import Customer.FirstProject.mapper.CustomerMapper;
import Customer.FirstProject.requests.Create.CreateCustomerRequest;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import Customer.FirstProject.service.CustomerManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
public class CustomerController {
    private final CustomerManager customerManager;

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName(createCustomerRequest.getCustomerName());
        customerDto.setCustomerSurname(createCustomerRequest.getCustomerSurname());
        customerDto.setCustomerTC(createCustomerRequest.getCustomerTC());
        customerDto.setPhoneNumberId(createCustomerRequest.getPhoneNumberId());
        customerDto.setEmailId(createCustomerRequest.getEmailId());
        customerDto.setPaymentId(createCustomerRequest.getPaymentId());
        customerDto.setAddressId(createCustomerRequest.getAddressId());
        customerDto.setStoreId(createCustomerRequest.getStoreId());
        CustomerEntity customerEntity = CustomerMapper.INSTANCE.dtoToModel(customerDto);
        customerManager.createCustomer(customerEntity);
        System.out.println("Customer : " + customerEntity + " Created Successfully");

    }

    @GetMapping("/{customerId}")
    public CustomerEntity getCustomerById(@PathVariable int customerId) {
        CustomerEntity customerEntity = customerManager.getById(customerId);
        customerManager.checkIfIdExists(customerId);
        return customerEntity;
    }

    @PatchMapping("/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody UpdateCustomerRequest updateCustomer) {
        customerManager.checkIfIdExists(customerId);
        customerManager.updateCustomer(customerId, updateCustomer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        if (customerManager.checkIfIdExists(customerId))
            customerManager.delete(customerId);
        else
            throw new RuntimeException("başarmadık abi");


    }
}



