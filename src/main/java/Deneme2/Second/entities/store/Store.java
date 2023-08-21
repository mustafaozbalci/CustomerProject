package Deneme2.Second.entities.store;
import Deneme2.Second.entities.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "store", schema = "customer_application")
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Integer storeId;

    @Column(name = "storeName")
    private String storeName;

    @OneToMany(mappedBy = "store")
    private List<Customer> customers;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private Stock stock;

    @OneToMany(mappedBy = "store")
    private List<Product> products;

}
