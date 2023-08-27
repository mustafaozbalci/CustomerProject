package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.StoreDto;
import Customer.FirstProject.requests.Create.CreateStoreRequest;
import Customer.FirstProject.requests.Update.UpdateStoreRequest;
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
    public StoreDto getStoreById(@PathVariable int storeId) {
        return storeService.getStore(storeId);
    }

    @DeleteMapping("/{storeId}")
    public void deleteStore(@PathVariable int storeId) {
        storeService.deleteStore(storeId);
    }

    @PatchMapping("/{storeId}")
    public void UpdateStock(@PathVariable int storeId, @RequestBody UpdateStoreRequest updateStoreRequest) {
        storeService.updateStore(storeId, updateStoreRequest);
    }
}
