package Customer.FirstProject.service;

import Customer.FirstProject.Dto.ProductDto;
import Customer.FirstProject.dataAccess.ProductRepository;
import Customer.FirstProject.entities.store.ProductEntity;
import Customer.FirstProject.mapper.ProductMapper;
import Customer.FirstProject.serviceAbstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void addProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toEntity(productDto);
        productRepository.save(productEntity);
        System.out.println("Product : " + productEntity + " Created Successfully");
    }
}
