package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.ProductDto;
import Customer.FirstProject.requests.Update.UpdateProductRequest;

public interface ProductService {
    void addProduct(ProductDto productDto);

    ProductDto getProduct(int productId);

    void deleteProduct(int id);

    void updateProduct(int productId, UpdateProductRequest updateProductRequest);
}
