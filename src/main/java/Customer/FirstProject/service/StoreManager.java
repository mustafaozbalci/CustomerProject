package Customer.FirstProject.service;

import Customer.FirstProject.dataAccess.ProductRepository;
import Customer.FirstProject.dataAccess.StockRepository;
import Customer.FirstProject.dataAccess.StoreRepository;
import Customer.FirstProject.entities.store.ProductEntity;
import Customer.FirstProject.entities.store.StockEntity;
import Customer.FirstProject.entities.store.StoreEntity;
import Customer.FirstProject.requests.Create.CreateStoreRequest;
import Customer.FirstProject.serviceAbstracts.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreManager implements StoreService {
    private final StoreRepository storeRepository;
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Autowired
    public StoreManager(StoreRepository storeRepository, StockRepository stockRepository, ProductRepository productRepository) {
        this.storeRepository = storeRepository;
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    public StoreEntity createStore(CreateStoreRequest createStoreRequest) {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setStoreName(createStoreRequest.getStoreName());

        // Create stock
        StockEntity stockEntity = new StockEntity();
        stockEntity.setQuantity(createStoreRequest.getCreateStockRequest().getQuantity());
        stockEntity.setStoreEntity(storeEntity); // Set the relationship
        stockRepository.save(stockEntity);

        // Create product
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(createStoreRequest.getCreateProductRequest().getProductName());
        productEntity.setPrice(createStoreRequest.getCreateProductRequest().getPrice());
        productEntity.setStockEntity(stockEntity);
        productRepository.save(productEntity);

        storeEntity.setStockEntity(stockEntity);
        storeEntity.setProductEntity(productEntity);
        return storeRepository.save(storeEntity);
    }
    public StoreEntity getStoreById(Integer storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }
}
