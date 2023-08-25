package Customer.FirstProject.requests.Create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {
    private String cityName;
    private String countryName;
}
