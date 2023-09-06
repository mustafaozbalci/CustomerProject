package Customer.FirstProject.service;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.dataAccess.EmailRepository;
import Customer.FirstProject.entities.contact.EmailEntity;
import Customer.FirstProject.mapper.EmailMapper;
import Customer.FirstProject.requests.Update.UpdateEmailRequest;
import Customer.FirstProject.serviceAbstracts.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmailManager implements EmailService {
    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;
    private final LogServiceImp logService;


    public void addEmail(EmailDto emailDto) {
        if (checkIfEmailAdressExists(emailDto.getEmailAddress())) {
            String errorMessage = "This Email " + emailDto.getEmailAddress() + " Already Exists";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        EmailEntity emailEntity = emailMapper.toEntity(emailDto);
        emailRepository.save(emailEntity);
        String successMessage = "Email : " + emailEntity + " Successfully Added.";
        logService.saveLog(successMessage);
    }

    public EmailDto getEmail(int emailId) {
        EmailEntity emailEntity = emailRepository.findById(emailId).orElse(null);
        if (emailEntity == null) {
            String errorMessage = "EmailEntity ID : " + emailId + " Not Found!, GetMapping Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return emailMapper.toDto(emailEntity);
    }

    public void deleteEmail(int emailId) {
        if (emailRepository.existsById(emailId)) {
            emailRepository.deleteById(emailId);
            String successMessage = "EmailEntity ID :  " + emailId + " Deleted Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "EmailEntity ID : " + emailId + " Not Found!, Delete Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void updateEmail(int emailId, UpdateEmailRequest updateEmailRequest) {
        EmailEntity existingEmailEntity = emailMapper.toEntity(getEmail(emailId));
        if (existingEmailEntity != null) {
            emailMapper.UpdateEmailFromRequest(updateEmailRequest, existingEmailEntity);
            emailRepository.save(existingEmailEntity);
            String successMessage = "EmailEntity ID : " + emailId + " Updated Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "EmailEntity ID : " + emailId + " Not Found!, Update failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public boolean checkIfEmailAdressExists(String emailAddress) {
        if (emailRepository.existsByEmailAddress(emailAddress))
            throw new RuntimeException("This emailAddress " + emailAddress + " Already Exists");
        return false;
    }
}
