package Customer.FirstProject.service;

import Customer.FirstProject.dataAccess.ProductRepository;
import Customer.FirstProject.entities.store.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductManager {

    private final ProductRepository productRepository;

    public ProductEntity addProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);


    }
}
