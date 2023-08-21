package Deneme2.Second.service;

import Deneme2.Second.entities.contact.PhoneNumber;
import Deneme2.Second.dataAccess.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberManager {
    private final PhoneNumberRepository phoneNumberRepository;

    @Autowired
    public PhoneNumberManager(PhoneNumberRepository phoneNumberRepository) {
        this.phoneNumberRepository = phoneNumberRepository;
    }

    public PhoneNumber addPhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumberRepository.existsByPhoneNumber(phoneNumber.getPhoneNumber())) {
            throw new RuntimeException("PHONE NUMBER ALREADY EXISTS");
        } else {

            return phoneNumberRepository.save(phoneNumber);
        }
    }
}
