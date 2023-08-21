package Deneme2.Second.entities.payment;

import Deneme2.Second.entities.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payment", schema = "customer_application")
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private int paymentId;

    @Column(name = "paymentAmount")
    private double paymentAmount;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "cardHolderName")
    private String cardHolderName;

    @Column(name = "expirationDate")
    private String expirationDate;

    @Column(name = "cvv")
    private String cvv;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

}
