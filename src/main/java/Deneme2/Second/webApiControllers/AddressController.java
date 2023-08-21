package Deneme2.Second.webApiControllers;

import Deneme2.Second.Service.AddressManager;
import Deneme2.Second.entities.address.Address;
import Deneme2.Second.requests.CreateAddressRequest;
import Deneme2.Second.dataAccess.CityRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressManager addressManager;
    private final CityRepository cityRepository; // Add this

    public AddressController(AddressManager addressManager, CityRepository cityRepository) {
        this.addressManager = addressManager;
        this.cityRepository = cityRepository;
    }

    @PostMapping
    public Address createAddress(@RequestBody CreateAddressRequest request) {
        return addressManager.createAddress(request);
    }
}
