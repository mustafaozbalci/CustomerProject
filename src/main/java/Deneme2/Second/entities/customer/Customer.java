package Deneme2.Second.entities.customer;

import Deneme2.Second.entities.address.Address;
import Deneme2.Second.entities.contact.PhoneNumber;
import Deneme2.Second.entities.payment.Payment;
import Deneme2.Second.entities.store.Store;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "customer", schema = "customer_application")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerSurname")
    private String customerSurname;

    @Column(name = "customer_TC")
    private String customerTC;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(mappedBy = "customer")
    private PhoneNumber phoneNumber;

    @OneToOne(mappedBy = "customer")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

}
