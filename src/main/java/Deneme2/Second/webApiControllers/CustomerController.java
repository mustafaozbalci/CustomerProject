package Deneme2.Second.webApiControllers;

import Deneme2.Second.entities.customer.Customer;
import Deneme2.Second.requests.CreateCustomerRequest;
import Deneme2.Second.requests.UpdateCustomerRequest;
import Deneme2.Second.service.AddressManager;
import Deneme2.Second.service.CustomerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerController {
    private final CustomerManager customerManager;
    private final AddressManager addressManager;

    @Autowired
    //Autowired ile üstteki service objesini consturctor ile bağlantılı hale getirdik.
    public CustomerController(CustomerManager customerManager, AddressManager addressManager) {

        this.customerManager = customerManager;

        this.addressManager = addressManager;
    }

    @PostMapping
    public void addCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        if (!customerManager.checkIfTCExists(createCustomerRequest.getCustomerTC())) {
            customerManager.addCustomer(createCustomerRequest);

        }
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        Customer customer = customerManager.getById(customerId);
        customerManager.checkIfIdExists(customerId);
        return customer;
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



