package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.PaymentDto;
import Customer.FirstProject.requests.Create.CreatePaymentRequest;
import Customer.FirstProject.requests.Update.UpdatePaymentRequest;
import Customer.FirstProject.serviceAbstracts.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public void addPayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setCardHolderName(createPaymentRequest.getCardHolderName());
        paymentDto.setCardNumber(createPaymentRequest.getCardNumber());
        paymentDto.setExpirationDate(createPaymentRequest.getExpirationDate());
        paymentDto.setCvv(createPaymentRequest.getCvv());
        paymentDto.setPaymentAmount(createPaymentRequest.getPaymentAmount());
        paymentService.addPayment(paymentDto);
    }

    @GetMapping("/{paymentId}")
    public PaymentDto getPayment(@PathVariable int paymentId) {
        PaymentDto paymentDto = paymentService.getPaymentById(paymentId);
        return paymentDto;
    }

    @DeleteMapping("/{paymentId}")
    public void deletePayment(@PathVariable int paymentId) {
        paymentService.deletePayment(paymentId);
    }

    @PatchMapping("/{paymentId}")
    public void updatePayment(@PathVariable int paymentId, @RequestBody UpdatePaymentRequest updatePaymentRequest) {
        paymentService.updatePayment(paymentId, updatePaymentRequest);
    }
}
