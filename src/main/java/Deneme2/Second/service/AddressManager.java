package Deneme2.Second.service;

import Deneme2.Second.dataAccess.AddressRepository;
import Deneme2.Second.dataAccess.CityRepository;
import Deneme2.Second.dataAccess.CountryRepository;
import Deneme2.Second.entities.address.Address;
import Deneme2.Second.entities.address.City;
import Deneme2.Second.entities.address.Country;
import Deneme2.Second.mapper.AddressMapper;
import Deneme2.Second.requests.Create.CreateAddressRequest;
import Deneme2.Second.requests.Create.CreateCityRequest;
import Deneme2.Second.requests.Create.CreateCountryRequest;
import Deneme2.Second.requests.Update.UpdateAddressRequest;
import Deneme2.Second.serviceAbstracts.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressManager implements AdressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public AddressManager(AddressRepository addressRepository, CityRepository cityRepository, CountryRepository countryRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.addressMapper = addressMapper;
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

    public Address getAddressById(int addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    public void delete(int addressId) {
        if (addressRepository.existsById(addressId)) {
            Address addressToDelete = getAddressById(addressId);
            addressRepository.deleteById(addressId);
        } else {
            throw new RuntimeException("Address not found");
        }
    }

    public boolean checkIfIdExists(int id) {
        if (addressRepository.existsById(id))
            return true;
        else {
            return false;
        }
    }

    public boolean checkAddressIfExists(int addressId) {
        if (addressRepository.existsByAddressId(addressId))
            throw new RuntimeException("This address " + addressId + " Already Exists");
        return false;
    }

    public void updateAddress(int addressId, UpdateAddressRequest updateAddressRequest) {
        Address existingAddress = getAddressById(addressId);

        if (existingAddress != null) {
            addressMapper.updateAddressFromRequest(updateAddressRequest, existingAddress);
            addressRepository.save(existingAddress);
        } else {
            throw new RuntimeException("Address not found");
        }
    }
}