package Deneme2.Second.requests.Create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStoreRequest {
    private String storeName;
    private CreateStockRequest createStockRequest;
    private CreateProductRequest createProductRequest;
}
