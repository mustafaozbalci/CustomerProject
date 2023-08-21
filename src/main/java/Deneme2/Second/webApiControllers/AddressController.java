package Deneme2.Second.webApiControllers;

import Deneme2.Second.entities.customer.Customer;
import Deneme2.Second.requests.UpdateAddressRequest;
import Deneme2.Second.requests.UpdateCustomerRequest;
import Deneme2.Second.service.AddressManager;
import Deneme2.Second.entities.address.Address;
import Deneme2.Second.requests.CreateAddressRequest;
import Deneme2.Second.dataAccess.CityRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressManager addressManager;
    private final CityRepository cityRepository;

    public AddressController(AddressManager addressManager, CityRepository cityRepository) {
        this.addressManager = addressManager;
        this.cityRepository = cityRepository;
    }

    @PostMapping
    public Address createAddress(@RequestBody CreateAddressRequest request) {
        return addressManager.createAddress(request);
    }
    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable int addressId) {
        return addressManager.getById(addressId);
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable int addressId) {
        if (addressManager.checkIfIdExists(addressId)) {
            addressManager.delete(addressId);
            System.out.println("Adres " + addressId + " başarıyla silindi. ");
        }
        else
            throw new RuntimeException("adres silmeyi başaramadık abi");
    }
    @PatchMapping("/{addressId}")
    public void updateAddress(@PathVariable int addressId, @RequestBody UpdateAddressRequest updateAddressRequest) {
        addressManager.checkIfIdExists(addressId);
        addressManager.updateAddress(addressId, updateAddressRequest);
    }

}
