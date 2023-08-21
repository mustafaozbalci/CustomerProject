package Deneme2.Second.webApiControllers;

import Deneme2.Second.entities.contact.Email;
import Deneme2.Second.requests.Create.CreateEmailRequest;
import Deneme2.Second.requests.Update.UpdateEmailRequest;
import Deneme2.Second.service.EmailManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/email")
public class EmailController {
    private final EmailManager emailManager;

    public EmailController(EmailManager emailManager) {
        this.emailManager = emailManager;
    }
    @PostMapping
    public void addEmail(@RequestBody CreateEmailRequest createEmailRequest) {
        if (!emailManager.checkIfEmailAdressExists(createEmailRequest.getEmailAddress())) {
            emailManager.addEmail(createEmailRequest);
            System.out.println("Adding Email " + createEmailRequest.getEmailAddress() + " Successfully...");

        }
    }

    @GetMapping("/{emailId}")
    public Email getEmailById(@PathVariable int emailId) {
        Email email = emailManager.getEmailById(emailId);
        return email;
    }

    @PatchMapping("/{emailId}")
    public void updateEmail(@PathVariable int emailId, @RequestBody UpdateEmailRequest updateEmailRequest) {
        emailManager.checkIfEmailIdExists(emailId);
        emailManager.updateEmail(emailId, updateEmailRequest);
        System.out.println("Update " + emailManager.getEmailById(emailId).getEmailAddress() + " Successfully changed to "
        + updateEmailRequest.getEmailAddress());
    }
    @DeleteMapping("/{emailId}")
    public void deleteEmail(int emailId){
        if (emailManager.checkIfEmailIdExists(emailId))
            emailManager.delete(emailId);
        else
            throw new RuntimeException("Delete " +emailId+ " Failed...");

    }
}
