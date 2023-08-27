package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.StockDto;
import Customer.FirstProject.requests.Update.UpdateStockRequest;

public interface StockService {
    void addStock(StockDto stockDto);

    StockDto getStock(int stockId);

    void deleteStock(int stockId);

    void updateStock(int stockId, UpdateStockRequest updateStockRequest);
}
