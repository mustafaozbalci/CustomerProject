package Deneme2.Second.requests.Create;

import Deneme2.Second.entities.customer.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {
    private CreateCountryRequest countryRequest; // Yeni ülke bilgileri
    private CreateCityRequest cityRequest;
    private Customer customer;
}
