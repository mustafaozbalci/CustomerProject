package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.StockDto;
import Customer.FirstProject.requests.Create.CreateStockRequest;
import Customer.FirstProject.requests.Update.UpdateStockRequest;
import Customer.FirstProject.serviceAbstracts.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    @PostMapping
    public void addStock(@RequestBody CreateStockRequest createStockRequest) {
        StockDto stockDto = new StockDto();
        stockDto.setQuantity(createStockRequest.getQuantity());
        stockService.addStock(stockDto);
    }

    @GetMapping("/{stockId}")
    public StockDto getStock(@PathVariable int stockId) {
        StockDto stockDto = stockService.getStock(stockId);
        return stockDto;
    }

    @DeleteMapping("/{stockId}")
    public void deleteStock(@PathVariable int stockId) {
        stockService.deleteStock(stockId);
    }

    @PatchMapping("/{stockId}")
    public void UpdateStock(@PathVariable int stockId, @RequestBody UpdateStockRequest updateStockRequest) {
        stockService.updateStock(stockId, updateStockRequest);
    }
}
