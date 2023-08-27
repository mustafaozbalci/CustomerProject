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
        System.out.println("PhoneNumber : " + phoneNumberEntity + " Successfully Added.");
    }

    public PhoneNumberDto getPhoneNumberById(int phoneNumberId) {
        PhoneNumberEntity phoneNumberEntity = phoneNumberRepository.findById(phoneNumberId).orElse(null);
        if (phoneNumberEntity == null)
            throw new RuntimeException("PhoneNumberEntity Id " + phoneNumberId + " Not Found!");
        return phoneNumberMapper.toDto(phoneNumberEntity);
    }

    public void deletePhone(int phoneNumberId) {
        if (phoneNumberRepository.existsById(phoneNumberId)) {
            phoneNumberRepository.deleteById(phoneNumberId);
            System.out.println("PhoneNumberEntity ID : " + phoneNumberId + " Deleted Successfully");

        } else {
            throw new RuntimeException("PhoneNumberEntity ID : " + phoneNumberId + " Not Found!");
        }
    }

    public void updatePhoneNumber(int phoneNumberId, UpdatePhoneNumberRequest updatePhoneNumberRequest) {
        PhoneNumberDto phoneNumberDto = getPhoneNumberById(phoneNumberId);
        PhoneNumberEntity phoneNumberEntity = phoneNumberMapper.toEntity(phoneNumberDto);
        if (phoneNumberDto != null) {
            phoneNumberMapper.UpdatePhoneNumberByRequest(updatePhoneNumberRequest, phoneNumberEntity);
            phoneNumberRepository.save(phoneNumberEntity);
            System.out.println("PhoneNumberEntity ID : " + phoneNumberId + " Updated Successfully");
        } else {
            throw new RuntimeException("PhoneNumberEntity ID " + phoneNumberId + " Not Found!, Update Failed ");
        }
    }


    public boolean checkIfphoneNumberIdExists(int phoneNumberId) {
        if (phoneNumberRepository.existsById(phoneNumberId))
            return true;
        else {
            return false;
        }
    }

}
