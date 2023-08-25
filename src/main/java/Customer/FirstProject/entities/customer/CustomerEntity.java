package Customer.FirstProject.entities.customer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customer", schema = "customer_application")
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerSurname")
    private String customerSurname;

    @Column(name = "customer_TC")
    private String customerTC;

    @Column(name = "addressId")
    private int addressId;

    @Column(name = "phoneNumberId")
    private int phoneNumberId;

    @Column(name = "emailId")
    private int emailId;

    @Column(name = "storeId")
    private int storeId;

    @Column(name = "paymentId")
    private int paymentId;
}
