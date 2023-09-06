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
    private final LogServiceImp logService;

    public void addPayment(PaymentDto paymentDto) {
        PaymentEntity paymentEntity = paymentMapper.toEntity(paymentDto);
        paymentRepository.save(paymentEntity);
        String successMessage = "Payment : " + paymentEntity + " Successfully Added.";
        logService.saveLog(successMessage);
    }

    public PaymentDto getPaymentById(int paymentId) {
        PaymentEntity paymentEntity = paymentRepository.findById(paymentId).orElse(null);
        if (paymentEntity == null) {
            String errorMessage = "PaymentEntity ID : " + paymentId + " Not Found!, GetMapping Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
        return paymentMapper.toDto(paymentEntity);
    }

    public void deletePayment(int paymentId) {
        if (paymentRepository.existsById(paymentId)) {
            paymentRepository.deleteById(paymentId);
            String successMessage = "PaymentEntity ID :  " + paymentId + " Deleted Successfully";
            logService.saveLog(successMessage);

        } else {
            String errorMessage = "PaymentEntity ID :  " + paymentId + " Not Found!, Delete Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    public void updatePayment(int paymentId, UpdatePaymentRequest updatePaymentRequest) {
        PaymentDto paymentDto = getPaymentById(paymentId);
        PaymentEntity paymentEntity = paymentMapper.toEntity(paymentDto);
        if (paymentDto != null) {
            paymentMapper.UpdatePaymentByRequest(updatePaymentRequest, paymentEntity);
            paymentRepository.save(paymentEntity);
            String successMessage = "PaymentEntity ID : " + paymentId + " Updated Successfully";
            logService.saveLog(successMessage);
        } else {
            String errorMessage = "PaymentEntity ID :  " + paymentId + " Not Found!, Update Failed.";
            logService.saveLog(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }
}
