package Customer.FirstProject.entities.store;

import Customer.FirstProject.entities.customer.CustomerEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "store", schema = "customer_application")
@Entity
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Integer storeId;

    @Column(name = "storeName")
    private String storeName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "stockId")
    private StockEntity stockEntity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private ProductEntity productEntity;
}
