package Customer.FirstProject.service;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.dataAccess.StoreRepository;
import Customer.FirstProject.entities.store.StoreEntity;
import Customer.FirstProject.mapper.StoreMapper;
import Customer.FirstProject.requests.Create.CreateStoreRequest;
import Customer.FirstProject.serviceAbstracts.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreManager implements StoreService {
    private final StoreRepository storeRepository;


    public StoreEntity createStore(StoreEntity storeEntity) {
        return storeRepository.save(storeEntity);

    }

    public StoreEntity getStoreById(Integer storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }
}
