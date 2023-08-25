package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.entities.store.StoreEntity;
import Customer.FirstProject.requests.Create.CreateStoreRequest;
import Customer.FirstProject.service.StoreManager;
import Customer.FirstProject.serviceAbstracts.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/store")
public class StoreController {
    private final StoreService storeService;
    @PostMapping
    public void createStore(@RequestBody CreateStoreRequest createStoreRequest) {
        StoreDto storeDto = new StoreDto();
        storeDto.setStoreName(createStoreRequest.getStoreName());
        storeService.createStore(storeDto);
    }
    @GetMapping("/{storeId}")
    public StoreEntity getStoreById(@PathVariable Integer storeId) {
        return storeService.getStoreById(storeId);
    }
}
