package Customer.FirstProject.entities.customer;

import Customer.FirstProject.entities.address.AddressEntity;
import Customer.FirstProject.entities.contact.PhoneNumberEntity;
import Customer.FirstProject.entities.payment.PaymentEntity;
import Customer.FirstProject.entities.store.StoreEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "customer", schema = "customer_application")
@Entity
public class CustomerEntity {
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

    @OneToOne(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

    @OneToOne(mappedBy = "customerEntity")
    private PhoneNumberEntity phoneNumberEntity;

    @OneToOne(mappedBy = "customerEntity")
    private PaymentEntity paymentEntity;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;

}
