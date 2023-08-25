package Customer.FirstProject.service;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.dataAccess.StoreRepository;
import Customer.FirstProject.entities.store.StoreEntity;
import Customer.FirstProject.mapper.StoreMapper;
import Customer.FirstProject.serviceAbstracts.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreManager implements StoreService {
    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;


    public void createStore(StoreDto storeDto) {
        StoreEntity storeEntity = storeMapper.toEntity(storeDto);
        storeRepository.save(storeEntity);
        System.out.println("Stock " + storeEntity + " Created Successfully");

    }

    public StoreEntity getStoreById(Integer storeId) {
        return storeRepository.findById(storeId).orElse(null);
    }
}
