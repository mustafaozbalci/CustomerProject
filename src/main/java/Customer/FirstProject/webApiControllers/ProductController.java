package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.ProductDto;
import Customer.FirstProject.requests.Create.CreateProductRequest;
import Customer.FirstProject.service.ProductManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductManager productManager;

    @PostMapping
    public void addProduct(@RequestBody CreateProductRequest createProductRequest) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(createProductRequest.getProductName());
        productDto.setPrice(createProductRequest.getPrice());
        productManager.addProduct(productDto);
    }
}
