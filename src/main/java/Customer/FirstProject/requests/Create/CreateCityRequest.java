package Customer.FirstProject.requests.Create;

import Customer.FirstProject.entities.address.CountryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCityRequest {
    private String cityName;
    private CountryEntity countryEntity;
}
