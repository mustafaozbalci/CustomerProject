package Customer.FirstProject.dataAccess;

import Customer.FirstProject.entities.address.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    CityEntity findByCityName(String cityName);
    boolean existsByCityName(String cityName);
}
