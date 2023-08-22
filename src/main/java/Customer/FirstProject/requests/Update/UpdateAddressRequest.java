package Customer.FirstProject.requests.Update;

import Customer.FirstProject.entities.address.CityEntity;
import Customer.FirstProject.entities.address.CountryEntity;
import Customer.FirstProject.entities.customer.CustomerEntity;
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

