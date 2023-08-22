package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.dataAccess.CityRepository;
import Customer.FirstProject.entities.address.AddressEntity;
import Customer.FirstProject.requests.Create.CreateAddressRequest;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import Customer.FirstProject.service.AddressManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressManager addressManager;
    private final CityRepository cityRepository;



    @PostMapping
    public AddressEntity createAddress(@RequestBody CreateAddressRequest request) {
        return addressManager.createAddress(request);
    }

    @GetMapping("/{addressId}")
    public AddressEntity getAddressById(@PathVariable int addressId) {
        return addressManager.getAddressById(addressId);
    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable int addressId) {
        if (addressManager.checkIfIdExists(addressId)) {
            addressManager.delete(addressId);
            System.out.println("Adres " + addressId + " başarıyla silindi. ");
        } else
            throw new RuntimeException("adres silmeyi başaramadık abi");
    }

    @PatchMapping("/{addressId}")
    public void updateAddress(@PathVariable int addressId, @RequestBody UpdateAddressRequest updateAddressRequest) {
        addressManager.checkIfIdExists(addressId);
        addressManager.updateAddress(addressId, updateAddressRequest);
    }

}
