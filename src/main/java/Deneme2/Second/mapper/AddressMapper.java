package Deneme2.Second.mapper;

import Deneme2.Second.entities.address.Address;
import Deneme2.Second.requests.Update.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel="spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "country.countryId", source = "request.country.countryId")
    @Mapping(target = "city.cityId", source = "request.city.cityId")
    void updateAddressFromRequest(UpdateAddressRequest request, @MappingTarget Address address);
}
