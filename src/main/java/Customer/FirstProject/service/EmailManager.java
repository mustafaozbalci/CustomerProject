package Customer.FirstProject.service;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.dataAccess.EmailRepository;
import Customer.FirstProject.entities.contact.EmailEntity;
import Customer.FirstProject.mapper.EmailMapper;
import Customer.FirstProject.serviceAbstracts.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class EmailManager implements EmailService {
    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;


    public boolean checkIfEmailAdressExists(String emailAddress) {
        if (emailRepository.existsByEmailAddress(emailAddress))
            throw new RuntimeException("This emailAddress " + emailAddress + " Already Exists");
        return false;
    }
    public boolean checkIfEmailIdExists(int emailId) {
        if (emailRepository.existsByEmailId(emailId))
            return true;
        else {
            return false;
        }
    }
    public void addEmail(EmailDto emailDto) {
        if (checkIfEmailAdressExists(emailDto.getEmailAddress())) {
            throw new RuntimeException("This Email " + emailDto.getEmailAddress() + " Already Exists");
        }
        EmailEntity emailEntity = emailMapper.toEntity(emailDto);
        emailRepository.save(emailEntity);
    }
    public EmailDto getEmailById(int emailId) {
        EmailEntity emailEntity = emailRepository.findById(emailId).orElse(null);
        return emailMapper.toDto(emailEntity);
    }
//    public void delete(int emailId) {
//        if (emailRepository.existsById(emailId)) {
//            EmailEntity emailEntityToDelete = getEmailById(emailId);
//            emailRepository.deleteById(emailId);
//        } else {
//            throw new RuntimeException("EmailEntity not found");
//        }
//    }
//    public void updateEmail(int emailId, UpdateEmailRequest updateEmailRequest) {
//        EmailEntity existingEmailEntity = getEmailById(emailId);
//        if (existingEmailEntity != null) {
//            emailMapper.updateEmailFromRequest(updateEmailRequest, existingEmailEntity);
//            emailRepository.save(existingEmailEntity);
//        } else {
//            throw new RuntimeException("EmailEntity not found, Update failed ");
//        }
//    }
}
