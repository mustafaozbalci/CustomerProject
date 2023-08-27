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
    private int addressId;
    private int phoneNumberId;
    private int emailId;
    private int paymentId;
    private int storeId;
}
/**
 * {"customerName": "example",
 *     "customerSurname": "example",
 *     "customerTC": "1111111",
 *     "addressId": 5,
 *     "phoneNumberId": 5,
 *     "emailId": 5,
 *     "paymentId": 5,
 *     "storeId": 5
 * }
 */