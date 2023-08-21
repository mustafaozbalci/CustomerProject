package Deneme2.Second.requests;

import Deneme2.Second.entities.customer.Customer;
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
    private Customer customer;
}
