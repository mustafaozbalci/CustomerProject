package Customer.FirstProject.requests.Update;

import Customer.FirstProject.requests.Create.CreateAddressRequest;
import Customer.FirstProject.requests.Create.CreateEmailRequest;
import Customer.FirstProject.requests.Create.CreatePaymentRequest;
import Customer.FirstProject.requests.Create.CreatePhoneNumberRequest;
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
}
