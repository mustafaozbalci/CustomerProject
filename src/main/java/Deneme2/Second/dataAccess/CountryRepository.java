package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.address.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    boolean existsByCountryName(String countryName);
    Country findByCountryName(String countryName);
}
