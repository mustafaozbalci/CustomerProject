package Customer.FirstProject.service;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.dataAccess.PaymentRepository;
import Customer.FirstProject.entities.payment.PaymentEntity;
import Customer.FirstProject.mapper.PaymentMapper;
import Customer.FirstProject.serviceAbstracts.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public boolean checkIfPaymentIdExists(int paymentId) {
        if (paymentRepository.existsById(paymentId))
            return true;
        return false;
    }
    public PaymentEntity addPayment(PaymentEntity paymentEntity) {
        return paymentRepository.save(paymentEntity);
    }
    public PaymentDto getPaymentById(int paymentId) {
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId).orElse(null);
        return paymentMapper.toDto(paymentEntity);
    }

//    public void delete(int paymentId) {
//        if (paymentRepository.existsByPaymentId(paymentId)) {
//            PaymentEntity paymentEntityToDelete = getPaymentById(paymentId);
//            paymentRepository.delete(paymentEntityToDelete);
//        } else {
//            throw new RuntimeException("PaymentEntity ID : " + paymentId + " not found");
//        }
//    }
//    public void updatePayment(int paymentId, UpdatePaymentRequest updatePaymentRequest) {
//        PaymentEntity existingPaymentEntity = getPaymentById(paymentId);
//        if (existingPaymentEntity != null) {
//            paymentMapper.UpdatePaymentByRequest(updatePaymentRequest, existingPaymentEntity);
//            paymentRepository.save(existingPaymentEntity);
//        } else {
//            throw new RuntimeException("PaymentEntity not found, Update failed ");
//        }
//    }
}
