package Customer.FirstProject.requests.Create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {
    private String customerName;
    private String customerSurname;
    private String customerTC;
    private int addressId;
    private int phoneNumberId;
    private int emailId;
    private int paymentId;
    private int storeId;
}

