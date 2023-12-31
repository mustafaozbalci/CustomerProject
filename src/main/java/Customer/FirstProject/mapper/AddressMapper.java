package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.entities.address.AddressEntity;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "addressId", ignore = true)
    @Mapping(target = "cityName", source = "cityId")
    @Mapping(target = "countryName", source = "countryId")
    AddressDto toDto(AddressEntity addressEntity);

    AddressEntity toEntity(AddressDto addressDto);

    @Mapping(target = "addressId", ignore = true)
    void UpdateAddressRequest(UpdateAddressRequest updateAddressRequest, @MappingTarget AddressDto addressDto);

}
