package Customer.FirstProject.webApiControllers;

import Customer.FirstProject.entities.contact.PhoneNumberEntity;
import Customer.FirstProject.requests.Update.UpdatePhoneNumberRequest;
import Customer.FirstProject.service.PhoneNumberManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phone")
public class PhoneNumberController {
    private final PhoneNumberManager phoneNumberManager;

    public PhoneNumberController(PhoneNumberManager phoneNumberManager) {
        this.phoneNumberManager = phoneNumberManager;
    }
    @PostMapping
    public void addPhoneNumber(@RequestBody PhoneNumberEntity phoneNumberEntity){
        PhoneNumberEntity newNumber = new PhoneNumberEntity();
        newNumber.setPhoneNumber(phoneNumberEntity.getPhoneNumber());
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
        }
        else
            throw new RuntimeException("Phone Number Delete is Not Successful");



    }

}