package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.requests.Create.CreateStoreRequest;
import Customer.FirstProject.service.StoreManager;
import Customer.FirstProject.entities.store.StoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/store")
public class StoreController {
    private final StoreManager storeManager;
    @Autowired
    public StoreController(StoreManager storeManager) {
        this.storeManager = storeManager;
    }

    @PostMapping
    public StoreEntity createStore(@RequestBody CreateStoreRequest createStoreRequest) {
        return storeManager.createStore(createStoreRequest);
    }
    @GetMapping("/{storeId}")
    public StoreEntity getStoreById(@PathVariable Integer storeId) {
        return storeManager.getStoreById(storeId);
    }
}
