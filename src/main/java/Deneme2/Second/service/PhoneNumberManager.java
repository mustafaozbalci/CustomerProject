package Deneme2.Second.service;

import Deneme2.Second.dataAccess.PhoneNumberRepository;
import Deneme2.Second.entities.contact.PhoneNumberEntity;
import Deneme2.Second.mapper.PhoneNumberMapper;
import Deneme2.Second.requests.Update.UpdatePhoneNumberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PhoneNumberManager {
    private final PhoneNumberRepository phoneNumberRepository;
    private final PhoneNumberMapper phoneNumberMapper;


    public PhoneNumberEntity addPhoneNumber(PhoneNumberEntity phoneNumberEntity) {
        if (phoneNumberRepository.existsByPhoneNumber(phoneNumberEntity.getPhoneNumber())) {
            throw new RuntimeException("PHONE NUMBER ALREADY EXISTS");
        } else {

            return phoneNumberRepository.save(phoneNumberEntity);
        }
    }
    public PhoneNumberEntity getPhoneNumberById(int phoneNumberId) {
        return phoneNumberRepository.findById(phoneNumberId).orElse(null);
    }
    public void updatePhoneNumber(int phoneNumberId, UpdatePhoneNumberRequest updatePhoneNumberRequest) {
        PhoneNumberEntity existingPhoneNumberEntity = getPhoneNumberById(phoneNumberId);

        if (existingPhoneNumberEntity != null) {
            phoneNumberMapper.updatePhoneNumberFromRequest(updatePhoneNumberRequest, existingPhoneNumberEntity);
            phoneNumberRepository.save(existingPhoneNumberEntity);
        } else {
            throw new RuntimeException("Phone Number not found");
        }
    }
    public void delete(int phoneNumberId) {
        if (phoneNumberRepository.existsById(phoneNumberId)) {
            PhoneNumberEntity phoneToDelete = getPhoneNumberById(phoneNumberId);
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
