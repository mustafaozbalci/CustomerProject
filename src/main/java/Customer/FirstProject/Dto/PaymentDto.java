package Customer.FirstProject.Dto;

import lombok.Data;

@Data
public class PaymentDto {
    private int paymentId;
    private String cardHolderName;
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private double paymentAmount;

}
