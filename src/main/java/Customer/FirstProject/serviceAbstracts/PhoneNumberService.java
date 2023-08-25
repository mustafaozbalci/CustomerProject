package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.PhoneNumberDto;
import Customer.FirstProject.requests.Update.UpdatePhoneNumberRequest;

public interface PhoneNumberService {
    void addPhoneNumber(PhoneNumberDto phoneNumberDto);

    PhoneNumberDto getPhoneNumberById(int phoneNumberId);
    void updatePhoneNumber(int phoneNumberId, UpdatePhoneNumberRequest updatePhoneNumberRequest);
    boolean checkIfphoneNumberIdExists(int phoneNumberId);
    void delete(int phoneNumberId);


}
