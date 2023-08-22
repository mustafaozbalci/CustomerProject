package Customer.FirstProject.entities.payment;

import Customer.FirstProject.entities.customer.CustomerEntity;
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
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private int paymentId;
    @Column(name = "cardHolderName")
    private String cardHolderName;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "expirationDate")
    private String expirationDate;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "paymentAmount")
    private double paymentAmount;
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private CustomerEntity customerEntity;

}
