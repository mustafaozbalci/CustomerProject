package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.entities.payment.PaymentEntity;
import Customer.FirstProject.mapper.PaymentMapper;
import Customer.FirstProject.requests.Create.CreatePaymentRequest;
import Customer.FirstProject.serviceAbstracts.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public void addPayment(@RequestBody CreatePaymentRequest createPaymentRequest){
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCardHolderName(createPaymentRequest.getCardHolderName());
        paymentDto.setCardNumber(createPaymentRequest.getCardNumber());
        paymentDto.setExpirationDate(createPaymentRequest.getExpirationDate());
        paymentDto.setCvv(createPaymentRequest.getCvv());
        paymentDto.setPaymentAmount(createPaymentRequest.getPaymentAmount());
        paymentService.addPayment(paymentDto);
    }
    @GetMapping("/{paymentId}")
    public PaymentDto getPayment(@PathVariable int paymentId){
        PaymentDto paymentDto = paymentService.getPaymentById(paymentId);
        return paymentDto;
    }
//    @PatchMapping("/{paymentId}")
//    public void updatePayment(@PathVariable int paymentId, @RequestBody UpdatePaymentRequest updatePaymentRequest) {
//        paymentService.checkIfPaymentIdExists(paymentId);
//        paymentService.updatePayment(paymentId, updatePaymentRequest);
//        System.out.println("Update paymentId : " + paymentId + " Successfully");
//    }
//    @DeleteMapping("/{paymentId}")
//    public void delete(@PathVariable int paymentId){
//        paymentService.checkIfPaymentIdExists(paymentId);
//        paymentService.delete(paymentId);
//        System.out.println("Deleting paymentId : " + paymentId + " Successfully Completed!");
//    }
}
