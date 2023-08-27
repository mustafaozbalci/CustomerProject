package Customer.FirstProject.service;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.dataAccess.StoreRepository;
import Customer.FirstProject.entities.store.StoreEntity;
import Customer.FirstProject.mapper.StoreMapper;
import Customer.FirstProject.requests.Update.UpdateStoreRequest;
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
        System.out.println("Store : " + storeEntity + " Created Successfully");

    }

    public StoreDto getStore(int storeId) {
        StoreEntity storeEntity = storeRepository.findById(storeId).orElse(null);
        if (storeEntity == null)
            throw new RuntimeException(("StoreEntity ID " + storeId + " Not Found!"));
        return storeMapper.toDto(storeEntity);
    }

    public void deleteStore(int storeId) {
        if (storeRepository.existsById(storeId)) {
            storeRepository.deleteById(storeId);
            System.out.println("StoreEntity ID : " + storeId + " Deleted Successfully");

        } else {
            throw new RuntimeException("StoreEntity ID " + storeId + " Not Found!");
        }
    }

    public void updateStore(int storeId, UpdateStoreRequest updateStoreRequest) {
        StoreDto storeDto = getStore(storeId);
        StoreEntity storeEntity = storeMapper.toEntity(storeDto);
        if (storeDto != null) {
            storeMapper.UpdateStoreByRequest(updateStoreRequest, storeEntity);
            storeRepository.save(storeEntity);
            System.out.println("StoreEntity ID : " + storeId + " Updated Successfully");
        } else {
            throw new RuntimeException("StoreEntity ID " + storeId + " Not Found!, Update failed ");
        }
    }
}
