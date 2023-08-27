package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.CountryDto;
import Customer.FirstProject.entities.address.CountryEntity;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "countryId", source = "countryId")
    CountryDto toDto(CountryEntity countryEntity);

    CountryEntity toEntity(CountryDto countryDto);

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "countryName", ignore = true)
    void UpdateCountryRequest(UpdateAddressRequest updateAddressRequest, @MappingTarget CountryEntity countryEntity);
}
