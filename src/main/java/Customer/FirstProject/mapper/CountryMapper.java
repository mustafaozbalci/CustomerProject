package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.CountryDto;
import Customer.FirstProject.entities.address.CountryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    @Mapping(target = "countryId", source = "countryId")
    CountryDto modelToDto(CountryEntity countryEntity);

    CountryEntity dtoToModel(CountryDto countryDto);

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
}
