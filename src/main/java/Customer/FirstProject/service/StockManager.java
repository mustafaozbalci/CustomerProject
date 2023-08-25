package Customer.FirstProject.service;

import Customer.FirstProject.Dto.StockDto;
import Customer.FirstProject.dataAccess.StockRepository;
import Customer.FirstProject.entities.store.StockEntity;
import Customer.FirstProject.mapper.StockMapper;
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
        System.out.println("Stock " + stockEntity + " Created Successfully");

    }

}
