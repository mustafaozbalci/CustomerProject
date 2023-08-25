package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.PhoneNumberDto;

public interface PhoneNumberService {
    void addPhoneNumber(PhoneNumberDto phoneNumberDto);

    PhoneNumberDto getPhoneNumberById(int phoneNumberId);

}
