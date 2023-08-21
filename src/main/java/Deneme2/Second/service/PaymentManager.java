package Deneme2.Second.service;

import Deneme2.Second.dataAccess.PaymentRepository;
import Deneme2.Second.entities.payment.Payment;
import Deneme2.Second.mapper.PaymentMapper;
import Deneme2.Second.requests.CreatePaymentRequest;
import Deneme2.Second.requests.UpdatePaymentRequest;
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
    public Payment addPayment(CreatePaymentRequest createPaymentRequest) {
        if (checkIfCardNumberExists(createPaymentRequest.getCardNumber())) {
            throw new RuntimeException("This Card Number " + createPaymentRequest.getCardNumber() + " Already Exists");
        }
        Payment payment = new Payment();
        BeanUtils.copyProperties(createPaymentRequest, payment);
        return paymentRepository.save(payment);
    }
    public Payment getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    public void delete(int paymentId) {
        if (paymentRepository.existsByPaymentId(paymentId)) {
            Payment paymentToDelete = getPaymentById(paymentId);
            paymentRepository.delete(paymentToDelete);
        } else {
            throw new RuntimeException("Payment ID : " + paymentId + " not found");
        }
    }
    public void updatePayment(int paymentId, UpdatePaymentRequest updatePaymentRequest) {
        Payment existingPayment = getPaymentById(paymentId);
        if (existingPayment != null) {
            paymentMapper.UpdatePaymentByRequest(updatePaymentRequest, existingPayment);
            paymentRepository.save(existingPayment);
        } else {
            throw new RuntimeException("Payment not found, Update failed ");
        }
    }
}
