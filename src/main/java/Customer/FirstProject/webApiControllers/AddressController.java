package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.requests.Create.CreateAddressRequest;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import Customer.FirstProject.serviceAbstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;


    @PostMapping()
    public void createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCountryName(createAddressRequest.getCountryName());
        addressDto.setCityName(createAddressRequest.getCityName());
        addressService.createAddress(addressDto);
    }

    @GetMapping("/{addressId}")
    public AddressDto getAddressById(@PathVariable int addressId) {
        AddressDto addressDto = addressService.getAddress(addressId);
        return addressDto;

    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable int addressId) {
        addressService.delete(addressId);
    }

    @PatchMapping("/{addressId}")
    public void updateAddress(@PathVariable int addressId, @RequestBody UpdateAddressRequest updateAddressRequest) {
        addressService.updateAddress(addressId, updateAddressRequest);
    }

}
