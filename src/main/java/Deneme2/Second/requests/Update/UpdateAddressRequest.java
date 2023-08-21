package Deneme2.Second.requests.Update;

import Deneme2.Second.entities.address.CityEntity;
import Deneme2.Second.entities.address.CountryEntity;
import Deneme2.Second.entities.customer.CustomerEntity;
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
    private CustomerEntity customerEntity;
    private CountryEntity countryEntity;
    private CityEntity cityEntity;
}
//      JSON EXAMPLE FOR UPDATE ADRESS
//      {
//        "countryEntity": {
//        "countryId": 22
//        },
//        "cityEntity": {
//        "cityId": 49
//        }
//        }

