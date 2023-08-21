package Deneme2.Second.entities.contact;

import Deneme2.Second.entities.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "phoneNumber", schema = "customer_application")
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phoneNumberId")
    private int phoneNumberId;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private Customer customer;




}
