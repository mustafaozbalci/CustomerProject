package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.entities.store.StoreEntity;
import Customer.FirstProject.requests.Update.UpdateStoreRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    @Mapping(target = "storeId", source = "storeId")
    StoreDto toDto(StoreEntity storeEntity);

    StoreEntity toEntity(StoreDto storeDto);

    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Mapping(target = "storeId", ignore = true)
    void UpdateStoreByRequest(UpdateStoreRequest updateStoreRequest, @MappingTarget StoreEntity storeEntity);
}

