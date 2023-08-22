package Customer.FirstProject.requests.Update;

import Customer.FirstProject.entities.customer.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdatePhoneNumberRequest {
    private int phoneNumberId;
    private String phoneNumber;
    private CustomerEntity customerEntity;
}
/**
 * JSON EXAMPLE FOR UPDATE PHONE NUMBER
 * localhost:8080/api/phone/phoneNumberId
 * {{
 *     "phoneNumber": 6549821985
 * }}
 */

