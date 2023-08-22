package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.mapper.PaymentMapper;
import Customer.FirstProject.requests.Create.CreatePaymentRequest;
import Customer.FirstProject.entities.payment.PaymentEntity;
import Customer.FirstProject.requests.Update.UpdatePaymentRequest;
import Customer.FirstProject.service.PaymentManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentManager paymentManager;

    @PostMapping
    public void addPayment(@RequestBody CreatePaymentRequest createPaymentRequest){
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCardHolderName(createPaymentRequest.getCardHolderName());
        paymentDto.setCardNumber(createPaymentRequest.getCardNumber());
        paymentDto.setExpirationDate(createPaymentRequest.getExpirationDate());
        paymentDto.setCvv(createPaymentRequest.getCvv());
        paymentDto.setPaymentAmount(createPaymentRequest.getPaymentAmount());
        PaymentEntity paymentEntity = PaymentMapper.INSTANCE.dtoToModel(paymentDto);
        paymentManager.addPayment(paymentEntity);
        System.out.println("Payment : " + paymentEntity + " Successfully Added.");

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
