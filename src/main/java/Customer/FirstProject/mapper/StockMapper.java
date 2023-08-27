package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.StockDto;
import Customer.FirstProject.entities.store.StockEntity;
import Customer.FirstProject.requests.Update.UpdateStockRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockMapper {
    @Mapping(target = "stockId", source = "stockId")
    StockDto toDto(StockEntity stockEntity);

    StockEntity toEntity(StockDto stockDto);

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    @Mapping(target = "stockId", ignore = true)
    void UpdateStockByRequest(UpdateStockRequest updateStockRequest, @MappingTarget StockEntity stockEntity);
}
