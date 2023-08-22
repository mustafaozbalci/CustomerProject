package Customer.FirstProject.requests.Create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStoreRequest {
    private String storeName;
    private CreateStockRequest createStockRequest;
    private CreateProductRequest createProductRequest;
}
/**
 * {
 *     "storeName": "UniqueStoreName",
 *     "createStockRequest": {
 *         "quantity": 100
 *     },
 *     "createProductRequest": {
 *         "productName": "Product1",
 *         "price": 49.99
 *     }
 * }
 */