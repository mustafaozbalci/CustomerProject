package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.requests.Update.UpdateStoreRequest;


public interface StoreService {
    void createStore(StoreDto storeDto);

    StoreDto getStore(int storeId);

    void deleteStore(int storeId);

    void updateStore(int storeId, UpdateStoreRequest updateStoreRequest);

}
