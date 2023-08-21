package Deneme2.Second.requests;

import Deneme2.Second.entities.address.Country;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCityRequest {
    private String cityName;
    private Country country;
}
