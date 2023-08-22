package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.ProductDto;
import Customer.FirstProject.entities.store.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "productId", target = "productId")
    ProductDto modelToDto(ProductEntity productEntity);

    ProductEntity dtoToModel(ProductDto productDto);

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
}
