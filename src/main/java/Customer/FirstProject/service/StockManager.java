package Customer.FirstProject.service;

import Customer.FirstProject.dataAccess.StockRepository;
import Customer.FirstProject.entities.store.StockEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockManager {
    private final StockRepository stockRepository;

    public StockEntity addStock(StockEntity stockEntity) {
        return stockRepository.save(stockEntity);


    }

}
