package Customer.FirstProject.service;

import Customer.FirstProject.Dto.PhoneNumberDto;
import Customer.FirstProject.dataAccess.PhoneNumberRepository;
import Customer.FirstProject.entities.contact.PhoneNumberEntity;
import Customer.FirstProject.mapper.PhoneNumberMapper;
import Customer.FirstProject.requests.Update.UpdatePhoneNumberRequest;
import Customer.FirstProject.serviceAbstracts.PhoneNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PhoneNumberManager implements PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;
    private final PhoneNumberMapper phoneNumberMapper;


    public void addPhoneNumber(PhoneNumberDto phoneNumberDto) {
        PhoneNumberEntity phoneNumberEntity = phoneNumberMapper.toEntity(phoneNumberDto);
        if (phoneNumberRepository.existsByPhoneNumber(phoneNumberEntity.getPhoneNumber())) {
            throw new RuntimeException("PHONE NUMBER ALREADY EXISTS");
        } else {
            phoneNumberRepository.save(phoneNumberEntity);
        }
        System.out.println("Phone number added : " + phoneNumberEntity);
    }

    public PhoneNumberDto getPhoneNumberById(int phoneNumberId) {
        PhoneNumberEntity phoneNumberEntity = phoneNumberRepository.findById(phoneNumberId).orElse(null);
        return phoneNumberMapper.toDto(phoneNumberEntity);
    }

    public void updatePhoneNumber(int phoneNumberId, UpdatePhoneNumberRequest updatePhoneNumberRequest) {
        PhoneNumberEntity existingPhoneNumberEntity = phoneNumberMapper.toEntity(getPhoneNumberById(phoneNumberId));

        if (existingPhoneNumberEntity != null) {
            phoneNumberMapper.updatePhoneNumberFromRequest(updatePhoneNumberRequest, existingPhoneNumberEntity);
            phoneNumberRepository.save(existingPhoneNumberEntity);
        } else {
            throw new RuntimeException("Phone Number not found");
        }
        System.out.println("Phone Number " + phoneNumberId + " Successfully Updated to : " + updatePhoneNumberRequest.getPhoneNumber());
    }

    public void delete(int phoneNumberId) {
        if (checkIfphoneNumberIdExists(phoneNumberId)) {
            phoneNumberRepository.deleteById(phoneNumberId);
            System.out.println("Phone Number " + phoneNumberId + " Successfully Deleted!");
        } else
            throw new RuntimeException("Phone Number Delete Failed");
    }

    public boolean checkIfphoneNumberIdExists(int phoneNumberId) {
        if (phoneNumberRepository.existsById(phoneNumberId))
            return true;
        else {
            return false;
        }
    }

}
