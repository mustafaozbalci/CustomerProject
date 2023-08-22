package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.entities.store.StoreEntity;
import Customer.FirstProject.mapper.StoreMapper;
import Customer.FirstProject.requests.Create.CreateStoreRequest;
import Customer.FirstProject.service.StoreManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/store")
public class StoreController {
    private final StoreManager storeManager;

    @PostMapping
    public void createStore(@RequestBody CreateStoreRequest createStoreRequest) {
        StoreDto storeDto = new StoreDto();
        storeDto.setStoreName(createStoreRequest.getStoreName());
        StoreEntity storeEntity = StoreMapper.INSTANCE.dtoToModel(storeDto);
        storeManager.createStore(storeEntity);
        System.out.println("Store " + storeEntity + " Created Successfully");
    }

    @GetMapping("/{storeId}")
    public StoreEntity getStoreById(@PathVariable Integer storeId) {
        return storeManager.getStoreById(storeId);
    }
}
