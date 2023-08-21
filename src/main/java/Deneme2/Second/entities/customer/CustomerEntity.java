package Deneme2.Second.entities.customer;

import Deneme2.Second.entities.address.AddressEntity;
import Deneme2.Second.entities.contact.PhoneNumberEntity;
import Deneme2.Second.entities.payment.PaymentEntity;
import Deneme2.Second.entities.store.StoreEntity;
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

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

    @OneToOne(mappedBy = "customer")
    private PhoneNumberEntity phoneNumberEntity;

    @OneToOne(mappedBy = "customer")
    private PaymentEntity paymentEntity;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity storeEntity;

}
