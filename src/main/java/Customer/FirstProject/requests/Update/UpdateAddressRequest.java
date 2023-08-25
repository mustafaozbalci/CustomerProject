package Customer.FirstProject.requests.Update;

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
    private int customerId;
    private int countryId;
    private int cityId;
}

