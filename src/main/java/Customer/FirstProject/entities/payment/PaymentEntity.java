package Customer.FirstProject.entities.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
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

}
