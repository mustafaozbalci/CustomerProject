package Deneme2.Second.webApiControllers;

import Deneme2.Second.entities.store.StoreEntity;
import Deneme2.Second.requests.Create.CreateStoreRequest;
import Deneme2.Second.service.StoreManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
