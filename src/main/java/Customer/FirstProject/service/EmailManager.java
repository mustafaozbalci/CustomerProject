package Customer.FirstProject.service;

import Customer.FirstProject.dataAccess.EmailRepository;
import Customer.FirstProject.entities.contact.EmailEntity;
import Customer.FirstProject.requests.Create.CreateEmailRequest;
import Customer.FirstProject.serviceAbstracts.EmailService;
import Customer.FirstProject.mapper.EmailMapper;
import Customer.FirstProject.requests.Update.UpdateEmailRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {
    private final EmailRepository emailRepository;
    private final EmailMapper emailMapper;

    @Autowired
    public EmailManager(EmailRepository emailRepository, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }
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
    public EmailEntity addEmail(CreateEmailRequest createEmailRequest) {
        if (checkIfEmailAdressExists(createEmailRequest.getEmailAddress())) {
            throw new RuntimeException("This TC " + createEmailRequest.getEmailAddress() + " Already Exists");
        }
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(createEmailRequest, emailEntity);
        return emailRepository.save(emailEntity);
    }
    public EmailEntity getEmailById(int emailId) {
        return emailRepository.findById(emailId).orElse(null);
    }
    public void delete(int emailId) {
        if (emailRepository.existsById(emailId)) {
            EmailEntity emailEntityToDelete = getEmailById(emailId);
            emailRepository.deleteById(emailId);
        } else {
            throw new RuntimeException("EmailEntity not found");
        }
    }
    public void updateEmail(int emailId, UpdateEmailRequest updateEmailRequest) {
        EmailEntity existingEmailEntity = getEmailById(emailId);
        if (existingEmailEntity != null) {
            emailMapper.updateEmailFromRequest(updateEmailRequest, existingEmailEntity);
            emailRepository.save(existingEmailEntity);
        } else {
            throw new RuntimeException("EmailEntity not found, Update failed ");
        }
    }
}
