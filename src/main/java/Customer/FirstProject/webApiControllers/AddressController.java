package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.entities.address.AddressEntity;
import Customer.FirstProject.mapper.AddressMapper;
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


    @PostMapping()
    public void createAddress(@RequestBody CreateAddressRequest createAddressRequest) {
        AddressDto addressDto = new AddressDto();
        addressDto.setCountryId(createAddressRequest.getCountryId());
        addressDto.setCityId(createAddressRequest.getCityId());
        AddressEntity addressEntity = AddressMapper.INSTANCE.dtoToModel(addressDto);
        addressManager.createAddress(addressEntity);
        System.out.println("Address " + addressEntity + " Successfully Created!");
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
