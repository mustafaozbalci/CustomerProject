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
    private final LogServiceImp logService;

    public void addProduct(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toEntity(productDto);
        productRepository.save(productEntity);
        String successMessage = "Product : " + productEntity + " Created Successfully";
        logService.saveLog(successMessage);
    }

    public ProductDto getProduct(int productId) {
        ProductEntity productEntity = productRepository.findById(productId).orElse(null);
        if (productEntity == null) {
            String errorMessage = "ProductEntity ID : " + productId + " Not Found!, GetMapping Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return productMapper.toDto(productEntity);
    }

    public void deleteProduct(int productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            String successMessage = "ProductEntity ID : " + productId + " Deleted Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "ProductEntity ID : " + productId + " Not Found!, Delete Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void updateProduct(int productId, UpdateProductRequest updateProductRequest) {
        ProductDto productDto = getProduct(productId);
        ProductEntity productEntity = productMapper.toEntity(productDto);
        if (productDto != null) {
            productMapper.UpdateProductByRequest(updateProductRequest, productEntity);
            productRepository.save(productEntity);
            String successMessage = "ProductEntity ID : " + productId + " Updated Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "ProductEntity ID : " + productId + " Not Found!, Update Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

}
