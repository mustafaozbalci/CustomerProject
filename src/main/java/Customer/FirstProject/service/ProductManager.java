package Customer.FirstProject.service;

import Customer.FirstProject.Dto.ProductDto;
import Customer.FirstProject.dataAccess.ProductRepository;
import Customer.FirstProject.entities.store.ProductEntity;
import Customer.FirstProject.mapper.ProductMapper;
import Customer.FirstProject.requests.Update.UpdateProductRequest;
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

    public ProductDto getProduct(int productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElse(null);
        return productMapper.toDto(productEntity);
    }

    public void delete(int productId) {
        if (productRepository.existsById(productId)) {
            ProductDto productToDelete = getProduct(productId);
            productRepository.delete(productMapper.toEntity(productToDelete));
            System.out.println("ProductEntity ID : " + productId + " Deleted Successfully");

        } else {
            throw new RuntimeException("ProductEntity ID : " + productId + " not found");
        }
    }

    public void updateProduct(int productId, UpdateProductRequest updateProductRequest) {
        ProductDto productDto = getProduct(productId);
        ProductEntity existingProductEntity = productMapper.toEntity(productDto);
        if (productDto != null) {
            productMapper.UpdateProductByRequest(updateProductRequest, existingProductEntity);
            productRepository.save(existingProductEntity);
            System.out.println("ProductEntity ID : " + productId + " Updated Successfully");
        } else {
            throw new RuntimeException("ProductEntity not found, Update failed ");
        }
    }

}
