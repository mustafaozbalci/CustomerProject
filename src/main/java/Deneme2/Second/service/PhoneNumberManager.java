package Deneme2.Second.service;

import Deneme2.Second.dataAccess.PhoneNumberRepository;
import Deneme2.Second.entities.contact.PhoneNumber;
import Deneme2.Second.mapper.PhoneNumberMapper;
import Deneme2.Second.requests.Update.UpdatePhoneNumberRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberManager {
    private final PhoneNumberRepository phoneNumberRepository;
    private final PhoneNumberMapper phoneNumberMapper;

    @Autowired
    public PhoneNumberManager(PhoneNumberRepository phoneNumberRepository, PhoneNumberMapper phoneNumberMapper) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.phoneNumberMapper = phoneNumberMapper;
    }

    public PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumberRepository.existsByPhoneNumber(phoneNumber.getPhoneNumber())) {
            throw new RuntimeException("PHONE NUMBER ALREADY EXISTS");
        } else {

            return phoneNumberRepository.save(phoneNumber);
        }
    }
    public PhoneNumber getPhoneNumberById(int phoneNumberId) {
        return phoneNumberRepository.findById(phoneNumberId).orElse(null);
    }
    public void updatePhoneNumber(int phoneNumberId, UpdatePhoneNumberRequest updatePhoneNumberRequest) {
        PhoneNumber existingPhoneNumber = getPhoneNumberById(phoneNumberId);

        if (existingPhoneNumber != null) {
            phoneNumberMapper.updatePhoneNumberFromRequest(updatePhoneNumberRequest, existingPhoneNumber);
            phoneNumberRepository.save(existingPhoneNumber);
        } else {
            throw new RuntimeException("Phone Number not found");
        }
    }
    public void delete(int phoneNumberId) {
        if (phoneNumberRepository.existsById(phoneNumberId)) {
            PhoneNumber phoneToDelete = getPhoneNumberById(phoneNumberId);
            phoneNumberRepository.deleteById(phoneNumberId);
        } else {
            throw new RuntimeException("Phone Number not found");
        }
    }

    public boolean checkIfphoneNumberIdExists(int phoneNumberId){
        if(phoneNumberRepository.existsById(phoneNumberId))
            return true;
        else {
            return false;
        }
    }

}
