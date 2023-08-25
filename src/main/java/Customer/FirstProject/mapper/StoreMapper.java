package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.entities.store.StoreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    @Mapping(target = "storeId", source = "storeId")
    StoreDto toDto(StoreEntity storeEntity);

    StoreEntity toEntity(StoreDto storeDto);

StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);
}

