package Deneme2.Second.entities.store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "product", schema = "customer_application")
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "price")
    private double price;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "stock_id", referencedColumnName = "stockId")
    private StockEntity stockEntity;

    @Transient
    private int stockId;
}
