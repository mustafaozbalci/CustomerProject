package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.StockDto;
import Customer.FirstProject.entities.store.StockEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockMapper {
    @Mapping(source = "stockId", target = "stockId")
    StockDto modelToDto(StockEntity stockEntity);

    StockEntity dtoToModel(StockDto stockDto);

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);
}
