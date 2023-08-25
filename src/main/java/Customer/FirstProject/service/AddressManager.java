package Customer.FirstProject.service;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.dataAccess.AddressRepository;
import Customer.FirstProject.dataAccess.CityRepository;
import Customer.FirstProject.dataAccess.CountryRepository;
import Customer.FirstProject.entities.address.AddressEntity;
import Customer.FirstProject.entities.address.CityEntity;
import Customer.FirstProject.entities.address.CountryEntity;
import Customer.FirstProject.mapper.AddressMapper;
import Customer.FirstProject.mapper.CityMapper;
import Customer.FirstProject.mapper.CountryMapper;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import Customer.FirstProject.serviceAbstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;


    public void createAddress(AddressDto addressDto) {
        CountryEntity countryEntity;
        CityEntity cityEntity;
        AddressEntity addressEntity = addressMapper.toEntity(addressDto);
        countryEntity = countryRepository.findByCountryName(addressEntity.getCountryName());
        cityEntity = cityRepository.findByCityName(addressEntity.getCityName());

        if (cityEntity == null && countryEntity != null) {
            CityEntity cityEntity1 = new CityEntity();
            cityEntity1.setCityName(addressEntity.getCityName());
            cityEntity1.setCountryId(countryEntity.getCountryId());
            cityRepository.save(cityEntity1);
            addressEntity.setCityId(cityEntity1.getCityId());
            addressEntity.setCountryId(countryEntity.getCountryId());
        } else if (countryEntity == null && cityEntity != null) {
            CountryEntity countryEntity1 = new CountryEntity();
            countryEntity1.setCountryName(addressEntity.getCountryName());
            countryRepository.save(countryEntity1);
            addressEntity.setCountryId(countryEntity1.getCountryId());
            cityEntity.setCountryId(countryEntity1.getCountryId());
        } else if (countryEntity == null && cityEntity == null) {
            CityEntity cityEntity2 = new CityEntity();
            CountryEntity countryEntity2 = new CountryEntity();
            countryEntity2.setCountryName(addressEntity.getCountryName());
            countryRepository.save(countryEntity2);
            cityEntity2.setCityName(addressEntity.getCityName());
            cityEntity2.setCountryId(countryEntity2.getCountryId());
            cityRepository.save(cityEntity2);
            addressEntity.setCityId(cityEntity2.getCityId());
            addressEntity.setCountryId(countryEntity2.getCountryId());
        } else {
            addressEntity.setCountryId(countryEntity.getCountryId());
            cityEntity.setCountryId(addressEntity.getCountryId());
            addressEntity.setCityId(cityEntity.getCityId());
        }
        addressRepository.save(addressEntity);
        System.out.println("Address " + addressEntity + " Successfully Created!");
    }

    public AddressDto getAddress(int addressId) {
        AddressEntity addressEntity = addressRepository.findById(addressId).orElse(null);
        if (addressEntity == null)
            throw new RuntimeException("Address Not Found " + addressId);
        AddressDto addressDto = addressMapper.toDto(addressEntity);
        addressDto.setAddressId(addressId);
        return addressDto;
    }


    public void delete(int addressId) {
        addressRepository.deleteById(addressId);
    }

    public void updateAddress(int addressId, UpdateAddressRequest updateAddressRequest) {
        AddressDto existingAddressDto = getAddress(addressId);

        if (existingAddressDto != null) {
            addressMapper.updateAddressRequest(updateAddressRequest, existingAddressDto);
            AddressEntity addressEntity = addressMapper.toEntity(existingAddressDto);
            CityEntity cityEntity = cityRepository.findByCityName(addressEntity.getCityName());
            CountryEntity countryEntity = countryRepository.findByCountryName(addressEntity.getCountryName());
            if (cityEntity == null && countryEntity != null) {
                cityEntity = new CityEntity();
                cityEntity.setCityName(addressEntity.getCityName());
                cityEntity.setCountryId(countryEntity.getCountryId());
                cityRepository.save(cityEntity);
                addressEntity.setCityId(cityEntity.getCityId());
                addressEntity.setCountryId(countryEntity.getCountryId());
            } else if (countryEntity == null && cityEntity != null) {
                countryEntity = new CountryEntity();
                countryEntity.setCountryName(addressEntity.getCountryName());
                countryRepository.save(countryEntity);
                addressEntity.setCountryId(countryEntity.getCountryId());
            } else if (countryEntity == null && cityEntity == null) {
                countryEntity = new CountryEntity();
                cityEntity = new CityEntity();
                countryEntity.setCountryName(addressEntity.getCountryName());
                countryRepository.save(countryEntity);
                cityEntity.setCityName(addressEntity.getCityName());
                cityEntity.setCountryId(countryEntity.getCountryId());
                cityRepository.save(cityEntity);
            } else {
                countryRepository.save(countryEntity);
                cityEntity.setCountryId(countryEntity.getCountryId());
                cityRepository.save(cityEntity);
                addressEntity.setCityId(cityEntity.getCityId());
                addressEntity.setCountryId(countryEntity.getCountryId());
            }
            addressRepository.save(addressEntity);
            System.out.println("Address " + addressEntity + " have been changed!");
        } else {
            throw new RuntimeException("AddressEntity not found");
        }
    }
}