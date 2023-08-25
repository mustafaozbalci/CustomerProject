package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.StockDto;
import Customer.FirstProject.requests.Create.CreateStockRequest;
import Customer.FirstProject.service.StockManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockManager stockManager;

    @PostMapping
    public void addStock(@RequestBody CreateStockRequest createStockRequest) {
        StockDto stockDto = new StockDto();
        stockDto.setQuantity(createStockRequest.getQuantity());
        stockManager.addStock(stockDto);
    }
}
