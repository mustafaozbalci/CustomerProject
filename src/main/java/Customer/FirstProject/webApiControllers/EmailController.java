package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.requests.Create.CreateEmailRequest;
import Customer.FirstProject.service.EmailManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/email")
public class EmailController {
    private final EmailManager emailManager;

    @PostMapping
    public void addEmail(@RequestBody CreateEmailRequest createEmailRequest) {
        if (!emailManager.checkIfEmailAdressExists(createEmailRequest.getEmailAddress())) {
            EmailDto emailDto = new EmailDto();
            emailDto.setEmailAddress(createEmailRequest.getEmailAddress());

            emailManager.addEmail(emailDto);

            System.out.println("Adding EmailEntity " + createEmailRequest.getEmailAddress() + " Successfully...");
        }
    }



    @GetMapping("/{emailId}")
    public EmailDto getEmailById(@PathVariable int emailId) {
        EmailDto emailDto = emailManager.getEmailById(emailId);
        return emailDto;
    }

//    @PatchMapping("/{emailId}")
//    public void updateEmail(@PathVariable int emailId, @RequestBody UpdateEmailRequest updateEmailRequest) {
//        emailManager.checkIfEmailIdExists(emailId);
//        emailManager.updateEmail(emailId, updateEmailRequest);
//        System.out.println("Update " + emailManager.getEmailById(emailId).getEmailAddress() + " Successfully changed to "
//                + updateEmailRequest.getEmailAddress());
//    }
//
//    @DeleteMapping("/{emailId}")
//    public void deleteEmail(@PathVariable int emailId) {
//        if (emailManager.checkIfEmailIdExists(emailId))
//            emailManager.delete(emailId);
//        else
//            throw new RuntimeException("Delete " + emailId + " Failed...");
//
//    }
}
