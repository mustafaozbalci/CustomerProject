package Customer.FirstProject.entities.address;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "country", schema = "customer_application")
@Entity
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countryId")
    private int countryId;

    @Column(name = "countryName")
    private String countryName;

    @OneToMany(mappedBy = "countryEntity", cascade = CascadeType.ALL)
    private List<AddressEntity> addressEntities;

    @OneToMany(mappedBy = "countryEntity", cascade = CascadeType.ALL)
    private List<CityEntity> cities;
}
