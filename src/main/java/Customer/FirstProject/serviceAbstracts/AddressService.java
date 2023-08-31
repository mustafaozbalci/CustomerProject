package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;

public interface AddressService {
    void createAddress(AddressDto addressDto);

    AddressDto getAddress(int addressId);

    void deleteAddress(int addressId);

    void updateAddress(int addressId, UpdateAddressRequest updateAddressRequest);


}
