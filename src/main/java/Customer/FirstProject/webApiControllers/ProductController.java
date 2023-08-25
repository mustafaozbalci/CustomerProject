package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.ProductDto;
import Customer.FirstProject.requests.Create.CreateProductRequest;
import Customer.FirstProject.service.ProductManager;
import Customer.FirstProject.serviceAbstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody CreateProductRequest createProductRequest) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(createProductRequest.getProductName());
        productDto.setPrice(createProductRequest.getPrice());
        productService.addProduct(productDto);
    }
    @GetMapping("/{productId}")
    public ProductDto getProduct (@PathVariable int productId){
        ProductDto productDto = productService.getProduct(productId);
        return productDto;
    }
}
