package Customer.FirstProject.service;

import Customer.FirstProject.Dto.AddressDto;
import Customer.FirstProject.dataAccess.AddressRepository;
import Customer.FirstProject.dataAccess.CityRepository;
import Customer.FirstProject.dataAccess.CountryRepository;
import Customer.FirstProject.entities.address.AddressEntity;
import Customer.FirstProject.entities.address.CityEntity;
import Customer.FirstProject.entities.address.CountryEntity;
import Customer.FirstProject.mapper.AddressMapper;
import Customer.FirstProject.requests.Update.UpdateAddressRequest;
import Customer.FirstProject.serviceAbstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final LogServiceImp logService;


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
            String successMessage = "Address " + addressEntity + " Successfully Created!";
            logService.saveLog(successMessage);
    }

    public AddressDto getAddress(int addressId) {
        AddressEntity addressEntity = addressRepository.findById(addressId).orElse(null);
        if (addressEntity == null) {
            String errorMessage = "AddressEntity ID : " + addressId + " Not Found!, GetMapping failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return addressMapper.toDto(addressEntity);

    }


    public void deleteAddress(int addressId) {
        if (addressRepository.existsById(addressId)) {
            addressRepository.deleteById(addressId);
            String successMessage = "AddressEntity ID :  " + addressId + " Deleted Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "AddressEntity ID : " + addressId + " Not Found!,Delete Failed.";
            logService.saveLog(errorMessage);
        }
    }

    public void updateAddress(int addressId, UpdateAddressRequest updateAddressRequest) {
        Optional<AddressEntity> existingAddress = addressRepository.findById(addressId);
        if (existingAddress == null) {
            String errorMessage = "AddressEntity ID : " + addressId + " Not Found!, Update Failed.";
            logService.saveLog(errorMessage);
        }
        AddressEntity addressEntity = existingAddress.get();
        CountryEntity byCountryName = countryRepository.findByCountryName(updateAddressRequest.getCountryName());
        CityEntity byCityNameAndCountryId = cityRepository.findByCityNameAndCountryId(updateAddressRequest.getCityName(), byCountryName.getCountryId());
        addressEntity.setCountryId(byCountryName.getCountryId());
        addressEntity.setCityId(byCityNameAndCountryId.getCityId());
        addressRepository.save(addressEntity);
        String successMessage = "AddressEntity ID :  " + addressId + " Updated Successfully";
        logService.saveLog(successMessage);

    }


}