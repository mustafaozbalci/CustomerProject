package Customer.FirstProject.entities.address;

import Customer.FirstProject.entities.customer.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "address", schema = "customer_application")
@Entity
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private int addressId;


    @Column(name = "country_id")
    private int countryId;

    @Column(name = "city_id")
    private int cityId;
}
