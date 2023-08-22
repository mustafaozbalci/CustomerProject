package Customer.FirstProject.service;

import Customer.FirstProject.dataAccess.AddressRepository;
import Customer.FirstProject.dataAccess.CityRepository;
import Customer.FirstProject.dataAccess.CountryRepository;
import Customer.FirstProject.entities.address.AddressEntity;
import Customer.FirstProject.entities.address.CityEntity;
import Customer.FirstProject.entities.address.CountryEntity;
import Customer.FirstProject.mapper.AddressMapper;
import Customer.FirstProject.requests.Create.CreateAddressRequest;
import Customer.FirstProject.requests.Create.CreateCityRequest;
import Customer.FirstProject.requests.Create.CreateCountryRequest;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import Customer.FirstProject.serviceAbstracts.AdressService;
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

    public AddressEntity createAddress(CreateAddressRequest request) {
        AddressEntity addressEntity = new AddressEntity();

        CreateCountryRequest countryRequest = request.getCountryRequest();
        String countryName = countryRequest.getCountryName();
        CountryEntity countryEntity;

        CreateCityRequest createCityRequest = request.getCityRequest();
        String cityName = createCityRequest.getCityName();
        CityEntity cityEntity;

        if (countryRepository.existsByCountryName(countryName)) {
            countryEntity = countryRepository.findByCountryName(countryName);
        } else {
            countryEntity = new CountryEntity();
            countryEntity.setCountryName(countryName);
            countryEntity = countryRepository.save(countryEntity);
        }

        if (cityRepository.existsByCityName(cityName)) {
            cityEntity = cityRepository.findByCityName(cityName);
        } else {
            cityEntity = new CityEntity();
            cityEntity.setCityName(cityName);
            cityEntity.setCountryEntity(countryEntity);
            cityEntity = cityRepository.save(cityEntity);
        }

        addressEntity.setCountryEntity(countryEntity);
        addressEntity.setCityEntity(cityEntity);

        return addressRepository.save(addressEntity);
    }

    public AddressEntity getAddressById(int addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    public void delete(int addressId) {
        if (addressRepository.existsById(addressId)) {
            AddressEntity addressEntityToDelete = getAddressById(addressId);
            addressRepository.deleteById(addressId);
        } else {
            throw new RuntimeException("AddressEntity not found");
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
        AddressEntity existingAddressEntity = getAddressById(addressId);

        if (existingAddressEntity != null) {
            addressMapper.updateAddressFromRequest(updateAddressRequest, existingAddressEntity);
            addressRepository.save(existingAddressEntity);
        } else {
            throw new RuntimeException("AddressEntity not found");
        }
    }
}