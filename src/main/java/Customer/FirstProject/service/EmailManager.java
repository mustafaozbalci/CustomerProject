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


    public void addEmail(EmailDto emailDto) {
        if (checkIfEmailAdressExists(emailDto.getEmailAddress())) {
            throw new RuntimeException("This Email " + emailDto.getEmailAddress() + " Already Exists");
        }
        EmailEntity emailEntity = emailMapper.toEntity(emailDto);
        emailRepository.save(emailEntity);
        System.out.println("Email : " + emailEntity + " Successfully Added.");
    }

    public EmailDto getEmail(int emailId) {
        EmailEntity emailEntity = emailRepository.findById(emailId).orElse(null);
        if (emailEntity == null)
            throw new RuntimeException("EmailEntity ID : " + emailId + " Not Found!");
        return emailMapper.toDto(emailEntity);
    }

    public void deleteEmail(int emailId) {
        if (emailRepository.existsById(emailId)) {
            emailRepository.deleteById(emailId);
            System.out.println("EmailEntity ID :  " + emailId + " Deleted Successfully");
        } else {
            throw new RuntimeException("EmailEntity ID : " + emailId + " Not Found!");
        }
    }

    public void updateEmail(int emailId, UpdateEmailRequest updateEmailRequest) {
        EmailEntity existingEmailEntity = emailMapper.toEntity(getEmail(emailId));
        if (existingEmailEntity != null) {
            emailMapper.UpdateEmailFromRequest(updateEmailRequest, existingEmailEntity);
            emailRepository.save(existingEmailEntity);
            System.out.println("EmailEntity ID : " + emailId + " Updated Successfully");
        } else {
            throw new RuntimeException("EmailEntity ID : " + emailId + " Not Found!, Update failed ");
        }
    }

    public boolean checkIfEmailAdressExists(String emailAddress) {
        if (emailRepository.existsByEmailAddress(emailAddress))
            throw new RuntimeException("This emailAddress " + emailAddress + " Already Exists");
        return false;
    }
}
