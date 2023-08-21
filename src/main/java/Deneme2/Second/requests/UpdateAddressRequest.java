package Deneme2.Second.requests;

import Deneme2.Second.entities.address.City;
import Deneme2.Second.entities.address.Country;
import Deneme2.Second.entities.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateAddressRequest {
    private int addressId;
    private Customer customer;
    private Country country;
    private City city;
}
//      JSON EXAMPLE FOR UPDATE ADRESS
//      {
//        "country": {
//        "countryId": 22
//        },
//        "city": {
//        "cityId": 49
//        }
//        }

