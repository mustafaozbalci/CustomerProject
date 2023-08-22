package Customer.FirstProject.entities.contact;

import Customer.FirstProject.entities.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "email", schema = "customer_application")
@Entity
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emailId")
    private int emailId;

    @Column(name = "emailAddress")
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private CustomerEntity customerEntity;

}
