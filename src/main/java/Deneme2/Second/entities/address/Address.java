package Deneme2.Second.entities.address;

import Deneme2.Second.entities.customer.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "address", schema = "customer_application")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private int addressId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "countryId")
    private Country country;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "cityId")
    private City city;
}
