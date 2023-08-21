package Deneme2.Second.requests.Create;

import Deneme2.Second.entities.customer.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {
    private CreateCountryRequest countryRequest;
    private CreateCityRequest cityRequest;
    private CustomerEntity customerEntity;
}
