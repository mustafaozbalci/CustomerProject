package Deneme2.Second.webApiControllers;

import Deneme2.Second.entities.contact.PhoneNumber;
import Deneme2.Second.requests.UpdatePhoneNumberRequest;
import Deneme2.Second.service.PhoneNumberManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phone")
public class PhoneNumberController {
    private final PhoneNumberManager phoneNumberManager;

    public PhoneNumberController(PhoneNumberManager phoneNumberManager) {
        this.phoneNumberManager = phoneNumberManager;
    }
    @PostMapping
    public void addPhoneNumber(@RequestBody PhoneNumber phoneNumber){
        PhoneNumber newNumber = new PhoneNumber();
        newNumber.setPhoneNumber(phoneNumber.getPhoneNumber());
        phoneNumberManager.addPhoneNumber(phoneNumber);
        System.out.println("Phone number added : " + phoneNumber);

    }
    @GetMapping("/{phoneNumberId}")
    public PhoneNumber getPhoneNumberById(@PathVariable int phoneNumberId) {
        PhoneNumber phoneNumber = phoneNumberManager.getPhoneNumberById(phoneNumberId);
        phoneNumberManager.checkIfphoneNumberIdExists(phoneNumberId);
        return phoneNumber;
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