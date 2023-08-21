package Deneme2.Second.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentRequest {
    private double paymentAmount;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;
}
