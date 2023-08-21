package Deneme2.Second.entities.contact;

import Deneme2.Second.entities.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "email", schema = "customer_application")
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emailId")
    private int emailId;

    @Column(name = "emailAddress")
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

}
