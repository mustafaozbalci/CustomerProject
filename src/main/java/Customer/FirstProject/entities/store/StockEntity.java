package Customer.FirstProject.entities.store;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "stock", schema = "customer_application")
@Entity
public class StockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockId")
    private Integer stockId;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne(mappedBy = "stockEntity", cascade = CascadeType.ALL)
    private StoreEntity storeEntity;
}
