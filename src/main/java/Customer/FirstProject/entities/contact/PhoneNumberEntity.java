package Customer.FirstProject.entities.contact;

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
@Table(name = "phoneNumber", schema = "customer_application")
@Entity
public class PhoneNumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phoneNumberId")
    private int phoneNumberId;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private CustomerEntity customerEntity;




}
