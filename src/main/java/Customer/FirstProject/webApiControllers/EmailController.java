package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.entities.contact.EmailEntity;
import Customer.FirstProject.mapper.EmailMapper;
import Customer.FirstProject.requests.Create.CreateEmailRequest;
import Customer.FirstProject.requests.Update.UpdateEmailRequest;
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

            EmailEntity emailEntity = EmailMapper.INSTANCE.dtoToModel(emailDto);
            emailManager.addEmail(emailEntity);

            System.out.println("Adding EmailEntity " + createEmailRequest.getEmailAddress() + " Successfully...");
        }
    }



    @GetMapping("/{emailId}")
    public EmailDto getEmailById(@PathVariable int emailId) {
        EmailEntity emailEntity = emailManager.getEmailById(emailId);
        EmailDto emailDto = EmailMapper.INSTANCE.modelToDto(emailEntity);
        return emailDto;
    }

    @PatchMapping("/{emailId}")
    public void updateEmail(@PathVariable int emailId, @RequestBody UpdateEmailRequest updateEmailRequest) {
        emailManager.checkIfEmailIdExists(emailId);
        emailManager.updateEmail(emailId, updateEmailRequest);
        System.out.println("Update " + emailManager.getEmailById(emailId).getEmailAddress() + " Successfully changed to "
                + updateEmailRequest.getEmailAddress());
    }

    @DeleteMapping("/{emailId}")
    public void deleteEmail(@PathVariable int emailId) {
        if (emailManager.checkIfEmailIdExists(emailId))
            emailManager.delete(emailId);
        else
            throw new RuntimeException("Delete " + emailId + " Failed...");

    }
}
