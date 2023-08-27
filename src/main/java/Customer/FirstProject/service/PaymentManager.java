package Customer.FirstProject.service;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.dataAccess.PaymentRepository;
import Customer.FirstProject.entities.payment.PaymentEntity;
import Customer.FirstProject.mapper.PaymentMapper;
import Customer.FirstProject.requests.Update.UpdatePaymentRequest;
import Customer.FirstProject.serviceAbstracts.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public void addPayment(PaymentDto paymentDto) {
        PaymentEntity paymentEntity = paymentMapper.toEntity(paymentDto);
        paymentRepository.save(paymentEntity);
        System.out.println("Payment : " + paymentEntity + " Successfully Added.");
    }

    public PaymentDto getPaymentById(int paymentId) {
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId).orElse(null);
        if (paymentEntity == null)
            throw new RuntimeException("PaymentEntity ID : " + paymentId + " Not Found! ");
        return paymentMapper.toDto(paymentEntity);
    }

    public void deletePayment(int paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
            System.out.println("PaymentEntity ID :  " + paymentId + " Deleted Successfully");

        } else {
            throw new RuntimeException("PaymentEntity ID :  " + paymentId + " Not Found!");
        }
    }

    public void updatePayment(int paymentId, UpdatePaymentRequest updatePaymentRequest) {
        PaymentDto paymentDto = getPaymentById(paymentId);
        PaymentEntity paymentEntity = paymentMapper.toEntity(paymentDto);
        if (paymentDto != null) {
            paymentMapper.UpdatePaymentByRequest(updatePaymentRequest, paymentEntity);
            paymentRepository.save(paymentEntity);
            System.out.println("PaymentEntity ID : " + paymentId + " Updated Successfully");
        } else {
            throw new RuntimeException("PaymentEntity ID :  " + paymentId + " Not Found!, Update Failed ");
        }
    }
}
