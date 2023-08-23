package Customer.FirstProject.entities.address;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "country", schema = "customer_application")
@Entity
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryId")
    private int countryId;

    @Column(name = "countryName")
    private String countryName;

    @Column(name = "cityId")
    private int cityId;
}
