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
    private final LogServiceImp logService;


    public void createStore(StoreDto storeDto) {
        StoreEntity storeEntity = storeMapper.toEntity(storeDto);
        storeRepository.save(storeEntity);
        String successMessage = "Store : " + storeEntity + " Created Successfully";
        logService.saveLog(successMessage);

    }

    public StoreDto getStore(int storeId) {
        StoreEntity storeEntity = storeRepository.findById(storeId).orElse(null);
        if (storeEntity == null) {
            String errorMessage = "StoreEntity ID " + storeId + " Not Found!, GetMapping Failed.";
            logService.saveLog(errorMessage);
        }
        return storeMapper.toDto(storeEntity);
    }

    public void deleteStore(int storeId) {
        if (storeRepository.existsById(storeId)) {
            storeRepository.deleteById(storeId);
            String successMessage = "StoreEntity ID : " + storeId + " Deleted Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "StoreEntity ID " + storeId + " Not Found!, Delete Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void updateStore(int storeId, UpdateStoreRequest updateStoreRequest) {
        StoreDto storeDto = getStore(storeId);
        StoreEntity storeEntity = storeMapper.toEntity(storeDto);
        if (storeDto != null) {
            storeMapper.UpdateStoreByRequest(updateStoreRequest, storeEntity);
            storeRepository.save(storeEntity);
            String successMessage = "StoreEntity ID : " + storeId + " Updated Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "StoreEntity ID " + storeId + " Not Found!, Update Failed. ";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }
}
