package Customer.FirstProject.dataAccess;

import Customer.FirstProject.entities.store.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity,Integer> {
}
