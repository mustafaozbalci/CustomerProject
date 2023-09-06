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
    private final LogServiceImp logService;

    public void addStock(StockDto stockDto) {
        StockEntity stockEntity = stockMapper.toEntity(stockDto);
        stockRepository.save(stockEntity);
        String successMessage = "Stock : " + stockEntity + " Created Successfully";
        logService.saveLog(successMessage);
    }

    public StockDto getStock(int stockId) {
        StockEntity stockEntity = stockRepository.findById(stockId).orElse(null);
        if (stockEntity == null) {
            String errorMessage = "StockEntity ID : " + stockId + " Not Found!, GetMapping Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return stockMapper.toDto(stockEntity);
    }

    public void deleteStock(int stockId) {
        if (stockRepository.existsById(stockId)) {
            stockRepository.deleteById(stockId);
            String successMessage = "StockEntity ID : " + stockId + " Deleted Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "StockEntity ID : " + stockId + " Not Found!, Delete Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void updateStock(int stockId, UpdateStockRequest updateStockRequest) {
        StockDto stockDto = getStock(stockId);
        StockEntity stockEntity = stockMapper.toEntity(stockDto);
        if (stockDto != null) {
            stockMapper.UpdateStockByRequest(updateStockRequest, stockEntity);
            stockRepository.save(stockEntity);
            String successMessage = "StockEntity ID : " + stockId + " Updated Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "StockEntity ID : " + stockId + "Not Found!, Update Failed. ";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

}
