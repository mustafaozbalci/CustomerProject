package Customer.FirstProject.serviceAbstracts;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.requests.Update.UpdatePaymentRequest;


public interface PaymentService {
    void addPayment(PaymentDto paymentDto);

    PaymentDto getPaymentById(int paymentId);

    void deletePayment(int paymentId);

    void updatePayment(int paymentId, UpdatePaymentRequest updatePaymentRequest);


}
