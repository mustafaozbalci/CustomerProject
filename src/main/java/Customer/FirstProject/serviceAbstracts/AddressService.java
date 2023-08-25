package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.entities.address.AddressEntity;

public interface AddressService {
    void createAddress(AddressDto addressDto);

    AddressDto getAddress(int addressId);

    void delete(int addressId);

    void updateAddress(int addressId, AddressEntity addressEntity);


}
