package Deneme2.Second.service;

import Deneme2.Second.dataAccess.EmailRepository;
import Deneme2.Second.entities.contact.Email;
import Deneme2.Second.entities.customer.Customer;
import Deneme2.Second.mapper.EmailMapper;
import Deneme2.Second.requests.CreateEmailRequest;
import Deneme2.Second.requests.UpdateCustomerRequest;
import Deneme2.Second.requests.UpdateEmailRequest;
import Deneme2.Second.serviceAbstracts.EmailService;
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
    public Email addEmail(CreateEmailRequest createEmailRequest) {
        if (checkIfEmailAdressExists(createEmailRequest.getEmailAddress())) {
            throw new RuntimeException("This TC " + createEmailRequest.getEmailAddress() + " Already Exists");
        }
        Email email = new Email();
        BeanUtils.copyProperties(createEmailRequest, email);
        return emailRepository.save(email);
    }
    public Email getEmailById(int emailId) {
        return emailRepository.findById(emailId).orElse(null);
    }
    public void delete(int emailId) {
        if (emailRepository.existsById(emailId)) {
            Email emailToDelete = getEmailById(emailId);
            emailRepository.deleteById(emailId);
        } else {
            throw new RuntimeException("Email not found");
        }
    }
    public void updateEmail(int emailId, UpdateEmailRequest updateEmailRequest) {
        Email existingEmail = getEmailById(emailId);
        if (existingEmail != null) {
            emailMapper.updateEmailFromRequest(updateEmailRequest, existingEmail);
            emailRepository.save(existingEmail);
        } else {
            throw new RuntimeException("Email not found, Update failed ");
        }
    }
}
