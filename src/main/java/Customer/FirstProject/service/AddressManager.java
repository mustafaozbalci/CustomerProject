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
import Customer.FirstProject.serviceAbstracts.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressManager implements AdressService {
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
        if(cityEntity == null){
            CityEntity cityEntity1 = new CityEntity();
            cityEntity1.setCityName(addressEntity.getCityName());
            cityEntity1.setCountryId(countryEntity.getCountryId());
            cityRepository.save(cityEntity1);
            addressEntity.setCityId(cityEntity1.getCityId());
        }
        else {
            cityRepository.save(cityEntity);
            addressEntity.setCityId(cityEntity.getCityId());
        }
        if(countryEntity == null) {
            CountryEntity countryEntity1 = new CountryEntity();
            countryEntity1.setCountryName(addressEntity.getCountryName());
            countryRepository.save(countryEntity1);
            addressEntity.setCountryId(countryEntity1.getCountryId());
        }
        else{
            countryRepository.save(countryEntity);
            cityEntity.setCountryId(countryEntity.getCountryId());
            addressEntity.setCountryId(countryEntity.getCountryId());
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

    public void updateAddress(int addressId, AddressEntity addressEntity) {
        addressRepository.existsByAddressId(addressId);
        addressRepository.save(addressEntity);
    }
}