package Customer.FirstProject.Dto;

import lombok.Data;

@Data
public class CustomerDto {
    private int customerId;
    private String customerName;
    private String customerSurname;
    private String customerTC;
    private int addressId;
    private int phoneNumberId;
    private int emailId;
    private int paymentId;
    private int storeId;
}