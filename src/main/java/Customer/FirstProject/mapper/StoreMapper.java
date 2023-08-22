package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.entities.store.StoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StoreMapper {

StoreDto modelToDto(StoreEntity storeEntity);

StoreEntity dtoToModel(StoreDto storeDto);

StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
}

