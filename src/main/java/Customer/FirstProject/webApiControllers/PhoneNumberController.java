package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.PhoneNumberDto;
import Customer.FirstProject.requests.Create.CreatePhoneNumberRequest;
import Customer.FirstProject.service.PhoneNumberManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/phone")
public class PhoneNumberController {
    private final PhoneNumberManager phoneNumberManager;

    @PostMapping
    public void addPhoneNumber(@RequestBody CreatePhoneNumberRequest phoneNumberRequest) {
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setPhoneNumber(phoneNumberRequest.getPhoneNumber());
        phoneNumberManager.addPhoneNumber(phoneNumberDto);
    }
    @GetMapping("/{phoneNumberId}")
    public PhoneNumberDto getPhoneNumberById(@PathVariable int phoneNumberId) {
        PhoneNumberDto phoneNumberDto = phoneNumberManager.getPhoneNumberById(phoneNumberId);

        return phoneNumberDto;
    }
//
//    @PatchMapping("/{phoneNumberId}")
//    public void updatePhoneNumber(@PathVariable int phoneNumberId, @RequestBody UpdatePhoneNumberRequest updatePhoneNumber) {
//        phoneNumberManager.checkIfphoneNumberIdExists(phoneNumberId);
//        phoneNumberManager.updatePhoneNumber(phoneNumberId, updatePhoneNumber);
//    }
//
//    @DeleteMapping("/{phoneNumberId}")
//    public void deleteCustomer(@PathVariable int phoneNumberId) {
//        if (phoneNumberManager.checkIfphoneNumberIdExists(phoneNumberId)) {
//            phoneNumberManager.delete(phoneNumberId);
//            System.out.println("Phone Number " + getPhoneNumberById(phoneNumberId) + " successfully deleted!");
//        } else
//            throw new RuntimeException("Phone Number Delete is Not Successful");
//
//
//    }

}