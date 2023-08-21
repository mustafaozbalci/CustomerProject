package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.address.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findByCityName(String cityName);
    boolean existsByCityName(String cityName);
}
