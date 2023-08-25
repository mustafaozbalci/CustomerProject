package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.StockDto;

public interface StockService {
    void addStock(StockDto stockDto);
    StockDto getStock(int stockId);
}
