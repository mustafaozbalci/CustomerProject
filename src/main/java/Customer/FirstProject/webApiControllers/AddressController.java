package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.requests.Create.CreateAddressRequest;
import Customer.FirstProject.service.AddressManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressManager addressManager;


    @PostMapping()
    public void createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCountryName(createAddressRequest.getCountryName());
        addressDto.setCityName(createAddressRequest.getCityName());
        addressManager.createAddress(addressDto);
    }

    @GetMapping("/{addressId}")
    public AddressDto getAddressById(@PathVariable int addressId) {
        AddressDto addressDto = addressManager.getAddress(addressId);
        return addressDto;

    }

    @DeleteMapping("/{addressId}")
    public void deleteAddress(@PathVariable int addressId) {
        addressManager.delete(addressId);
        System.out.println("Address " + addressId + " Deleted Successfully. ");
    }

//    @PatchMapping("/{addressId}")
//    public void updateAddress(@PathVariable int addressId, @RequestBody UpdateAddressRequest updateAddressRequest) {
//        AddressDto addressDto = new AddressDto();
//        addressDto.setAddressId(addressId);
//        addressDto.setCityId(updateAddressRequest.getCityId());
//        addressDto.setCountryId(updateAddressRequest.getCountryId());
//        AddressEntity addressEntity = AddressMapper.INSTANCE.toEntity(addressDto);
//
//        addressManager.updateAddress(addressId, addressEntity);
//        System.out.println("Update Address : " + addressEntity + " Successfully");
//    }

}
