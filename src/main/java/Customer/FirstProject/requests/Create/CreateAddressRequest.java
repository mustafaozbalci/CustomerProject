package Customer.FirstProject.requests.Create;

import Customer.FirstProject.entities.customer.CustomerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {
    private int cityId;
    private int countryId;
    private CustomerEntity customerEntity;
}
