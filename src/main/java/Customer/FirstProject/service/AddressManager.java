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

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

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
            throw new RuntimeException("AddressEntity ID : " + addressId + " Not Found!");
        return addressMapper.toDto(addressEntity);
    }


    public void deleteAddress(int addressId) {
        if (addressRepository.existsById(addressId)) {
            addressRepository.deleteById(addressId);
            System.out.println("AddressEntity ID :  " + addressId + " Deleted Successfully");
        } else {
            throw new RuntimeException("AddressEntity ID : " + addressId + " Not Found!");
        }
    }
        public void updateAddress(int addressId, UpdateAddressRequest updateAddressRequest) {
            Optional<AddressEntity> existingAddress = addressRepository.findById(addressId);
            if (existingAddress == null) {
                throw new RuntimeException("AddressEntity ID : " + addressId + " Not Found!");
            }
            AddressEntity addressEntity = existingAddress.get();
            CountryEntity byCountryName = countryRepository.findByCountryName(updateAddressRequest.getCountryName());
            CityEntity byCityNameAndCountryId = cityRepository.findByCityNameAndCountryId(updateAddressRequest.getCityName(), byCountryName.getCountryId());
            addressEntity.setCountryId(byCountryName.getCountryId());
            addressEntity.setCityId(byCityNameAndCountryId.getCityId());
            addressRepository.save(addressEntity);


            ArrayList arrayList = new ArrayList();
            arrayList.stream().filter(o -> false).collect(Collectors.toList());
    }


}