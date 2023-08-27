package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.requests.Update.UpdateEmailRequest;

public interface EmailService {
    boolean checkIfEmailAdressExists(String emailAddress);

    void addEmail(EmailDto emailDto);

    EmailDto getEmail(int emailId);

    void deleteEmail(int emailId);

    void updateEmail(int emailId, UpdateEmailRequest updateEmailRequest);

}
