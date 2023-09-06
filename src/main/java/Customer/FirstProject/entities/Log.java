package Customer.FirstProject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "log", schema = "customer_application")
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logId")
    private int logId;


    @Column(name = "log")
    private String log;

    @Column(name = "logDate")
    private LocalDate logDate;

}
