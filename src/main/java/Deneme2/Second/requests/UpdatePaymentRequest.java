package Deneme2.Second.requests;

import Deneme2.Second.entities.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePaymentRequest {

    private double paymentAmount;
    private String cardNumber;
    private String cardHolderName;
    private String expirationDate;
    private String cvv;
    private Customer customer;

}
