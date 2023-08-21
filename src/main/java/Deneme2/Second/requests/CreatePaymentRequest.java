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
/**
 * AN EXAMPLE JSON TO ADD PAYMENT
 * {
 *
 *     "cardHolderName": "NAME SURNAME",
 *     "cardNumber": "2222222222222222",    //must be 16 char
 *     "expirationDate": "08/26",           //must be 5 char
 *     "cvv": "666",                        //must be 3 char
 *     "paymentAmount": 750.0
 * }
 */
