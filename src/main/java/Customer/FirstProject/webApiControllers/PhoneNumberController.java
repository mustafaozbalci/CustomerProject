package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.PhoneNumberDto;
import Customer.FirstProject.requests.Create.CreatePhoneNumberRequest;
import Customer.FirstProject.requests.Update.UpdatePhoneNumberRequest;
import Customer.FirstProject.serviceAbstracts.PhoneNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/phone")
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    @PostMapping
    public void addPhoneNumber(@RequestBody CreatePhoneNumberRequest phoneNumberRequest) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setPhoneNumber(phoneNumberRequest.getPhoneNumber());
        phoneNumberService.addPhoneNumber(phoneNumberDto);
    }

    @GetMapping("/{phoneNumberId}")
    public PhoneNumberDto getPhoneNumberById(@PathVariable int phoneNumberId) {
        PhoneNumberDto phoneNumberDto = phoneNumberService.getPhoneNumberById(phoneNumberId);

        return phoneNumberDto;
    }

    @PatchMapping("/{phoneNumberId}")
    public void updatePhoneNumber(@PathVariable int phoneNumberId, @RequestBody UpdatePhoneNumberRequest updatePhoneNumber) {
        phoneNumberService.checkIfphoneNumberIdExists(phoneNumberId);
        phoneNumberService.updatePhoneNumber(phoneNumberId, updatePhoneNumber);
    }

    @DeleteMapping("/{phoneNumberId}")
    public void deleteCustomer(@PathVariable int phoneNumberId) {
        phoneNumberService.deletePhone(phoneNumberId);
    }

}