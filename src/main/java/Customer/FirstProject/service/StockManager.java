package Customer.FirstProject.service;

import Customer.FirstProject.Dto.StockDto;
import Customer.FirstProject.dataAccess.StockRepository;
import Customer.FirstProject.entities.store.StockEntity;
import Customer.FirstProject.mapper.StockMapper;
import Customer.FirstProject.requests.Update.UpdateStockRequest;
import Customer.FirstProject.serviceAbstracts.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockManager implements StockService {
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public void addStock(StockDto stockDto) {
        StockEntity stockEntity = stockMapper.toEntity(stockDto);
        stockRepository.save(stockEntity);
        System.out.println("Stock : " + stockEntity + " Created Successfully");
    }

    public StockDto getStock(int stockId) {
        StockEntity stockEntity = stockRepository.findById(stockId).orElse(null);
        if (stockEntity == null)
            throw new RuntimeException("StockEntity ID : " + stockId + " Not Found!");
        return stockMapper.toDto(stockEntity);
    }

    public void deleteStock(int stockId) {
        if (stockRepository.existsById(stockId)) {
            stockRepository.deleteById(stockId);
            System.out.println("StockEntity ID : " + stockId + " Deleted Successfully");

        } else {
            throw new RuntimeException("StockEntity ID : " + stockId + " Not Found!");
        }
    }

    public void updateStock(int stockId, UpdateStockRequest updateStockRequest) {
        StockDto stockDto = getStock(stockId);
        StockEntity stockEntity = stockMapper.toEntity(stockDto);
        if (stockDto != null) {
            stockMapper.UpdateStockByRequest(updateStockRequest, stockEntity);
            stockRepository.save(stockEntity);
            System.out.println("StockEntity ID : " + stockId + " Updated Successfully");
        } else {
            throw new RuntimeException("StockEntity ID : " + stockId + "Not Found!, Update failed ");
        }
    }

}
