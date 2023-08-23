package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.CityDto;
import Customer.FirstProject.entities.address.CityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(target = "cityId", source = "cityId")
    CityDto modelToDto(CityEntity cityEntity);

    CityEntity dtoToModel(CityDto cityDto);

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
}
