package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.service.AddressManager;
import Customer.FirstProject.service.CustomerManager;
import Customer.FirstProject.entities.customer.CustomerEntity;
import Customer.FirstProject.requests.Create.CreateCustomerRequest;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/customer")
public class CustomerController {
    private final CustomerManager customerManager;
    private final AddressManager addressManager;

    @PostMapping
    public void addCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        if (!customerManager.checkIfTCExists(createCustomerRequest.getCustomerTC())) {
            customerManager.addCustomer(createCustomerRequest);


        }
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



