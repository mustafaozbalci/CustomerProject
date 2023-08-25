package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.CustomerDto;
import Customer.FirstProject.requests.Create.CreateCustomerRequest;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import Customer.FirstProject.serviceAbstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customer")
public class CustomerController {
    private final CustomerService customerService;

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
        customerService.createCustomer(customerDto);


    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomerById(@PathVariable int customerId) {
        CustomerDto customerDto = customerService.getCustomer(customerId);
        return customerDto;
    }

    @PatchMapping("/{customerId}")
    public void updateCustomer(@PathVariable int customerId, @RequestBody UpdateCustomerRequest updateCustomer) {
        customerService.updateCustomer(customerId, updateCustomer);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        if (customerService.checkIfIdExists(customerId))
            customerService.delete(customerId);
        else
            throw new RuntimeException("Customer delete Failed...");
    }
}



