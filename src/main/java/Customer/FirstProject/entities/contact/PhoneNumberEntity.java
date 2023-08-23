package Customer.FirstProject.entities.contact;

import Customer.FirstProject.entities.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "phoneNumber", schema = "customer_application")
@Entity
public class PhoneNumberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phoneNumberId")
    private int phoneNumberId;

    @Column(name = "phoneNumber")
    private String phoneNumber;


}
