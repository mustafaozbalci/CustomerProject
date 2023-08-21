package Deneme2.Second.webApiControllers;

import Deneme2.Second.entities.contact.PhoneNumber;
import Deneme2.Second.entities.payment.Payment;
import Deneme2.Second.requests.CreatePaymentRequest;
import Deneme2.Second.requests.UpdatePaymentRequest;
import Deneme2.Second.service.PaymentManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentManager paymentManager;

    public PaymentController(PaymentManager paymentManager) {
        this.paymentManager = paymentManager;
    }
    @PostMapping
    public void addPayment(@RequestBody CreatePaymentRequest createPaymentRequest){
        paymentManager.checkIfCardNumberExists(createPaymentRequest.getCardNumber());
        paymentManager.addPayment(createPaymentRequest);
        System.out.println("Payment Card Number : " + createPaymentRequest.getCardNumber() + " Successfully Added.");

    }
    @GetMapping("/{paymentId}")
    public Payment getPayment(@PathVariable int paymentId){
        Payment payment = paymentManager.getPaymentById(paymentId);
        return payment;
    }
    @PatchMapping("/{paymentId}")
    public void updatePayment(@PathVariable int paymentId, @RequestBody UpdatePaymentRequest updatePaymentRequest) {
        paymentManager.checkIfPaymentIdExists(paymentId);
        paymentManager.updatePayment(paymentId, updatePaymentRequest);
        System.out.println("Update paymentId : " + paymentId + " Successfully");
    }
    @DeleteMapping("/{paymentId}")
    public void delete(@PathVariable int paymentId){
        paymentManager.checkIfPaymentIdExists(paymentId);
        paymentManager.delete(paymentId);
        System.out.println("Deleting paymentId : " + paymentId + " Successfully Completed!");
    }
}
