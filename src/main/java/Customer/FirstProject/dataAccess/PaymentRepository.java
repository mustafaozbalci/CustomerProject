package Customer.FirstProject.dataAccess;

import Customer.FirstProject.entities.payment.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity,Integer> {
    boolean existsByPaymentId(int paymentId);
    boolean existsByCardNumber(String cardNumber);
}
