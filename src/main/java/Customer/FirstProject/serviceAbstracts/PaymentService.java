package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.entities.payment.PaymentEntity;
import org.springframework.stereotype.Service;


public interface PaymentService {
    PaymentEntity addPayment(PaymentEntity paymentEntity);

    PaymentDto getPaymentById(int paymentId);


}
