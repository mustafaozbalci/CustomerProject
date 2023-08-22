package Customer.FirstProject.requests.Create;

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
 *     {
 *     "cardHolderName": "Name Surname",
 *     "cardNumber": "3216549873216547",
 *     "expirationDate": "12/23",
 *     "cvv": "521",
 *     "paymentAmount": 321.98
 * }
 */
