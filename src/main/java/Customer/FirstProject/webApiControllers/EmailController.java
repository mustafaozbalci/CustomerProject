package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.requests.Create.CreateEmailRequest;
import Customer.FirstProject.requests.Update.UpdateEmailRequest;
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
        }
    }


    @GetMapping("/{emailId}")
    public EmailDto getEmailById(@PathVariable int emailId) {
        EmailDto emailDto = emailService.getEmail(emailId);
        return emailDto;
    }

    @PatchMapping("/{emailId}")
    public void updateEmail(@PathVariable int emailId, @RequestBody UpdateEmailRequest updateEmailRequest) {
        emailService.updateEmail(emailId, updateEmailRequest);
    }

    @DeleteMapping("/{emailId}")
    public void deleteEmail(@PathVariable int emailId) {
        emailService.deleteEmail(emailId);
    }
}
