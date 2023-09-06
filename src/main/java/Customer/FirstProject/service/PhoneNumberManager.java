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
    private final LogServiceImp logService;


    public void addPhoneNumber(PhoneNumberDto phoneNumberDto) {
        PhoneNumberEntity phoneNumberEntity = phoneNumberMapper.toEntity(phoneNumberDto);
        if (phoneNumberRepository.existsByPhoneNumber(phoneNumberEntity.getPhoneNumber())) {
            String errorMessage = "PHONE NUMBER ALREADY EXISTS";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        } else {
            phoneNumberRepository.save(phoneNumberEntity);
            String successMessage = "PhoneNumber : " + phoneNumberEntity + " Successfully Added.";
            logService.saveLog(successMessage);
        }
    }

    public PhoneNumberDto getPhoneNumberById(int phoneNumberId) {
        PhoneNumberEntity phoneNumberEntity = phoneNumberRepository.findById(phoneNumberId).orElse(null);
        if (phoneNumberEntity == null) {
            String errorMessage = "PhoneNumberEntity Id " + phoneNumberId + " Not Found!, GetMapping Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return phoneNumberMapper.toDto(phoneNumberEntity);
    }

    public void deletePhone(int phoneNumberId) {
        if (phoneNumberRepository.existsById(phoneNumberId)) {
            phoneNumberRepository.deleteById(phoneNumberId);
            String successMessage = "PhoneNumberEntity ID : " + phoneNumberId + " Deleted Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "PhoneNumberEntity ID : " + phoneNumberId + " Not Found!, Delete Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void updatePhoneNumber(int phoneNumberId, UpdatePhoneNumberRequest updatePhoneNumberRequest) {
        PhoneNumberDto phoneNumberDto = getPhoneNumberById(phoneNumberId);
        PhoneNumberEntity phoneNumberEntity = phoneNumberMapper.toEntity(phoneNumberDto);
        if (phoneNumberDto != null) {
            phoneNumberMapper.UpdatePhoneNumberByRequest(updatePhoneNumberRequest, phoneNumberEntity);
            phoneNumberRepository.save(phoneNumberEntity);
            String successMessage = "PhoneNumberEntity ID : " + phoneNumberId + " Updated Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "PhoneNumberEntity ID " + phoneNumberId + " Not Found!, Update Failed. ";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
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
