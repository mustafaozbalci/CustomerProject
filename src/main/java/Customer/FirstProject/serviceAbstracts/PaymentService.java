package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.entities.payment.PaymentEntity;
import org.springframework.stereotype.Service;


public interface PaymentService {
    void addPayment(PaymentDto paymentDto);

    PaymentDto getPaymentById(int paymentId);


}
