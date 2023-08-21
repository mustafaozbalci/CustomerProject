package Deneme2.Second.webApiControllers;

import Deneme2.Second.service.PhoneNumberManager;
import Deneme2.Second.entities.contact.PhoneNumber;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}