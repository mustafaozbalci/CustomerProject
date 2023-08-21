package Deneme2.Second.service;

import Deneme2.Second.dataAccess.ProductRepository;
import Deneme2.Second.dataAccess.StockRepository;
import Deneme2.Second.dataAccess.StoreRepository;
import Deneme2.Second.entities.store.ProductEntity;
import Deneme2.Second.entities.store.StockEntity;
import Deneme2.Second.entities.store.StoreEntity;
import Deneme2.Second.requests.Create.CreateProductRequest;
import Deneme2.Second.requests.Create.CreateStockRequest;
import Deneme2.Second.requests.Create.CreateStoreRequest;
import Deneme2.Second.serviceAbstracts.StoreService;
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
        StockEntity stockEntity = new StockEntity();
        ProductEntity productEntity = new ProductEntity();

        CreateProductRequest createProductRequest = createStoreRequest.getCreateProductRequest();
        productEntity.setProductName(createProductRequest.getProductName());
        productEntity.setPrice(createProductRequest.getPrice());
        productEntity.setStockId(createProductRequest.getStockId());
        productRepository.save(productEntity);
        storeEntity.setProductEntity(productEntity);

        CreateStockRequest createStockRequest = createStoreRequest.getCreateStockRequest();
        stockEntity.setQuantity(createStockRequest.getQuantity());
        stockEntity.setStoreEntity(storeEntity);
        stockRepository.save(stockEntity);
        storeEntity.setStockEntity(stockEntity);



        storeEntity.setStoreName(createStoreRequest.getStoreName());
        return storeRepository.save(storeEntity);
    }
}
