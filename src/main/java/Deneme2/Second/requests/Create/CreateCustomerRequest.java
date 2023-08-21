package Deneme2.Second.requests.Create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {
    private String customerName;
    private String customerSurname;
    private String customerTC;
    private CreateAddressRequest address;
    private CreatePhoneNumberRequest phoneNumber;
    private CreateEmailRequest email;
    private CreatePaymentRequest payment;
}

