package Customer.FirstProject.requests.Create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private double price;
    private String productName;
}
/**
 * AN EXAMPLE JSON TO ADD Product
 * "productName" : "Example"
 * "price" : 100.00
 */

