package Deneme2.Second.Service;

import Deneme2.Second.entities.address.Address;
import Deneme2.Second.entities.address.City;
import Deneme2.Second.entities.address.Country;
import Deneme2.Second.requests.CreateAddressRequest;
import Deneme2.Second.requests.CreateCityRequest;
import Deneme2.Second.requests.CreateCountryRequest;
import Deneme2.Second.dataAccess.AddressRepository;
import Deneme2.Second.dataAccess.CityRepository;
import Deneme2.Second.dataAccess.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressManager {
    private final AddressRepository addressRepository;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public AddressManager(AddressRepository addressRepository, CityRepository cityRepository, CountryRepository countryRepository) {
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public Address createAddress(CreateAddressRequest request) {
        Address address = new Address();

        CreateCountryRequest countryRequest = request.getCountryRequest();
        String countryName = countryRequest.getCountryName();
        Country country;

        CreateCityRequest createCityRequest = request.getCityRequest();
        String cityName = createCityRequest.getCityName();
        City city;

        if (countryRepository.existsByCountryName(countryName)) {
            country = countryRepository.findByCountryName(countryName);
        } else {
            country = new Country();
            country.setCountryName(countryName);
            country = countryRepository.save(country);
        }

        if (cityRepository.existsByCityName(cityName)) {
            city = cityRepository.findByCityName(cityName);
        } else {
            city = new City();
            city.setCityName(cityName);
            city.setCountry(country);
            city = cityRepository.save(city);
        }

        address.setCountry(country);
        address.setCity(city);

        return addressRepository.save(address);
    }
}
