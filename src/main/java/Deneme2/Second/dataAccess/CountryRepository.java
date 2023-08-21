package Deneme2.Second.dataAccess;

import Deneme2.Second.entities.address.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
    boolean existsByCountryName(String countryName);
    CountryEntity findByCountryName(String countryName);
}
