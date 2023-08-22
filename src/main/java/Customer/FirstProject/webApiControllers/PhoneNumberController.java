package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.Dto.PhoneNumberDto;
import Customer.FirstProject.entities.contact.PhoneNumberEntity;
import Customer.FirstProject.mapper.PhoneNumberMapper;
import Customer.FirstProject.requests.Create.CreatePhoneNumberRequest;
import Customer.FirstProject.requests.Update.UpdatePhoneNumberRequest;
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
        PhoneNumberEntity phoneNumberEntity = PhoneNumberMapper.INSTANCE.dtoToModel(phoneNumberDto);
        phoneNumberManager.addPhoneNumber(phoneNumberEntity);
        System.out.println("Phone number added : " + phoneNumberEntity);

    }

    @GetMapping("/{phoneNumberId}")
    public PhoneNumberEntity getPhoneNumberById(@PathVariable int phoneNumberId) {
        PhoneNumberEntity phoneNumberEntity = phoneNumberManager.getPhoneNumberById(phoneNumberId);
        phoneNumberManager.checkIfphoneNumberIdExists(phoneNumberId);
        return phoneNumberEntity;
    }

    @PatchMapping("/{phoneNumberId}")
    public void updatePhoneNumber(@PathVariable int phoneNumberId, @RequestBody UpdatePhoneNumberRequest updatePhoneNumber) {
        phoneNumberManager.checkIfphoneNumberIdExists(phoneNumberId);
        phoneNumberManager.updatePhoneNumber(phoneNumberId, updatePhoneNumber);
    }

    @DeleteMapping("/{phoneNumberId}")
    public void deleteCustomer(@PathVariable int phoneNumberId) {
        if (phoneNumberManager.checkIfphoneNumberIdExists(phoneNumberId)) {
            phoneNumberManager.delete(phoneNumberId);
            System.out.println("Phone Number " + getPhoneNumberById(phoneNumberId) + " successfully deleted!");
        } else
            throw new RuntimeException("Phone Number Delete is Not Successful");


    }

}