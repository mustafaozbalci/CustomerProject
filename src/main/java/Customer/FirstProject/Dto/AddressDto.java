package Customer.FirstProject.Dto;

import lombok.Data;

@Data
public class AddressDto {
    private int addressId;
    private String countryName;
    private String cityName;
}