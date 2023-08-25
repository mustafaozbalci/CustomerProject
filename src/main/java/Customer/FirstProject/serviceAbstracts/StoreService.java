package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.entities.store.StoreEntity;
import org.springframework.stereotype.Service;


public interface StoreService {
    void createStore(StoreDto storeDto);

    StoreEntity getStoreById(Integer storeId);
}
