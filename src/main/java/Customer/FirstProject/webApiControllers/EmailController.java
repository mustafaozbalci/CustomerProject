package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.requests.Create.CreateEmailRequest;
import Customer.FirstProject.serviceAbstracts.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/email")
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public void addEmail(@RequestBody CreateEmailRequest createEmailRequest) {
        if (!emailService.checkIfEmailAdressExists(createEmailRequest.getEmailAddress())) {
            EmailDto emailDto = new EmailDto();
            emailDto.setEmailAddress(createEmailRequest.getEmailAddress());

            emailService.addEmail(emailDto);

            System.out.println("Adding EmailEntity " + createEmailRequest.getEmailAddress() + " Successfully...");
        }
    }



    @GetMapping("/{emailId}")
    public EmailDto getEmailById(@PathVariable int emailId) {
        EmailDto emailDto = emailService.getEmailById(emailId);
        return emailDto;
    }

//    @PatchMapping("/{emailId}")
//    public void updateEmail(@PathVariable int emailId, @RequestBody UpdateEmailRequest updateEmailRequest) {
//        emailService.checkIfEmailIdExists(emailId);
//        emailService.updateEmail(emailId, updateEmailRequest);
//        System.out.println("Update " + emailService.getEmailById(emailId).getEmailAddress() + " Successfully changed to "
//                + updateEmailRequest.getEmailAddress());
//    }
//
//    @DeleteMapping("/{emailId}")
//    public void deleteEmail(@PathVariable int emailId) {
//        if (emailService.checkIfEmailIdExists(emailId))
//            emailService.delete(emailId);
//        else
//            throw new RuntimeException("Delete " + emailId + " Failed...");
//
//    }
}
