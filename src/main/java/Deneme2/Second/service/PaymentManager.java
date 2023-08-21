package Deneme2.Second.service;

import Deneme2.Second.dataAccess.PaymentRepository;
import Deneme2.Second.entities.payment.PaymentEntity;
import Deneme2.Second.mapper.PaymentMapper;
import Deneme2.Second.requests.Create.CreatePaymentRequest;
import Deneme2.Second.requests.Update.UpdatePaymentRequest;
import Deneme2.Second.serviceAbstracts.PaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PaymentManager implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;


    public PaymentManager(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    /**
     * It checks whether there is such a payment in the database according to the Card Number.
     * @param cardNumber
     * @return
     */
    public boolean checkIfCardNumberExists(String cardNumber) {
        if (paymentRepository.existsByCardNumber(cardNumber))
            return true;
        else {
            return false;
        }
    }

    public boolean checkIfPaymentIdExists(int paymentId) {
        if (paymentRepository.existsById(paymentId))
            return true;
        return false;
    }
    public PaymentEntity addPayment(CreatePaymentRequest createPaymentRequest) {
        if (checkIfCardNumberExists(createPaymentRequest.getCardNumber())) {
            throw new RuntimeException("This Card Number " + createPaymentRequest.getCardNumber() + " Already Exists");
        }
        PaymentEntity paymentEntity = new PaymentEntity();
        BeanUtils.copyProperties(createPaymentRequest, paymentEntity);
        return paymentRepository.save(paymentEntity);
    }
    public PaymentEntity getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    public void delete(int paymentId) {
        if (paymentRepository.existsByPaymentId(paymentId)) {
            PaymentEntity paymentEntityToDelete = getPaymentById(paymentId);
            paymentRepository.delete(paymentEntityToDelete);
        } else {
            throw new RuntimeException("PaymentEntity ID : " + paymentId + " not found");
        }
    }
    public void updatePayment(int paymentId, UpdatePaymentRequest updatePaymentRequest) {
        PaymentEntity existingPaymentEntity = getPaymentById(paymentId);
        if (existingPaymentEntity != null) {
            paymentMapper.UpdatePaymentByRequest(updatePaymentRequest, existingPaymentEntity);
            paymentRepository.save(existingPaymentEntity);
        } else {
            throw new RuntimeException("PaymentEntity not found, Update failed ");
        }
    }
}
