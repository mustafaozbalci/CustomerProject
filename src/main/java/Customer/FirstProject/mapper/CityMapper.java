package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.CityDto;
import Customer.FirstProject.entities.address.CityEntity;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "cityId", source = "cityId")
    CityDto toDto(CityEntity cityEntity);

    CityEntity toEntity(CityDto cityDto);

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(target = "cityName", ignore = true)
    void UpdateCityRequest(UpdateAddressRequest updateAddressRequest, @MappingTarget CityEntity cityEntity);
}
