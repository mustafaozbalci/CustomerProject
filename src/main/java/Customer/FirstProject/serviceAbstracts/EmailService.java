package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.EmailDto;

public interface EmailService {
    boolean checkIfEmailAdressExists(String emailAddress);

    void addEmail(EmailDto emailDto);

    EmailDto getEmailById(int emailId);
}
