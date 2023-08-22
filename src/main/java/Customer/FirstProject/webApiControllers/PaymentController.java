package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.requests.Create.CreatePaymentRequest;
import Customer.FirstProject.entities.payment.PaymentEntity;
import Customer.FirstProject.requests.Update.UpdatePaymentRequest;
import Customer.FirstProject.service.PaymentManager;
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
        System.out.println("PaymentEntity Card Number : " + createPaymentRequest.getCardNumber() + " Successfully Added.");

    }
    @GetMapping("/{paymentId}")
    public PaymentEntity getPayment(@PathVariable int paymentId){
        PaymentEntity paymentEntity = paymentManager.getPaymentById(paymentId);
        return paymentEntity;
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
