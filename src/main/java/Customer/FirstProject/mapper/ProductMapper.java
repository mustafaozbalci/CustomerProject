package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.ProductDto;
import Customer.FirstProject.entities.store.ProductEntity;
import Customer.FirstProject.requests.Update.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "productId", target = "productId")
    ProductDto toDto(ProductEntity productEntity);

    ProductEntity toEntity(ProductDto productDto);

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "productId", ignore = true)
    void UpdateProductByRequest(UpdateProductRequest request, @MappingTarget ProductEntity productEntity);
}
