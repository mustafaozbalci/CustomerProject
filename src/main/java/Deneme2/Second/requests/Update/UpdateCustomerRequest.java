package Deneme2.Second.requests.Update;

import Deneme2.Second.requests.Create.CreateAddressRequest;
import Deneme2.Second.requests.Create.CreateEmailRequest;
import Deneme2.Second.requests.Create.CreatePaymentRequest;
import Deneme2.Second.requests.Create.CreatePhoneNumberRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCustomerRequest {
    private Integer customerId;
    private String customerName;
    private String customerSurname;
    private String customerTC;
    private CreateAddressRequest address;
    private CreatePhoneNumberRequest phoneNumber;
    private CreateEmailRequest email;
    private CreatePaymentRequest payment;
}
