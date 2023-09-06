package Customer.FirstProject;

import Customer.FirstProject.Dto.PhoneNumberDto;
import Customer.FirstProject.dataAccess.PhoneNumberRepository;
import Customer.FirstProject.entities.contact.PhoneNumberEntity;
import Customer.FirstProject.mapper.PhoneNumberMapper;
import Customer.FirstProject.requests.Update.UpdatePhoneNumberRequest;
import Customer.FirstProject.service.PhoneNumberManager;
import Customer.FirstProject.serviceAbstracts.PhoneNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PhoneNumberManagerTest {

    @Mock
    private PhoneNumberRepository phoneNumberRepository;

    @Mock
    private PhoneNumberMapper phoneNumberMapper;

    private PhoneNumberService phoneNumberService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        phoneNumberService = new PhoneNumberManager(phoneNumberRepository, phoneNumberMapper);
    }

    @Test
    public void testAddPhoneNumber() {

        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setPhoneNumber("1234567890");

        PhoneNumberEntity phoneNumberEntity = new PhoneNumberEntity();
        phoneNumberEntity.setPhoneNumberId(1);
        phoneNumberEntity.setPhoneNumber("1234567890");

        when(phoneNumberMapper.toEntity(phoneNumberDto)).thenReturn(phoneNumberEntity);
        when(phoneNumberRepository.existsByPhoneNumber(phoneNumberDto.getPhoneNumber())).thenReturn(false);

        phoneNumberService.addPhoneNumber(phoneNumberDto);

        verify(phoneNumberMapper).toEntity(phoneNumberDto);
        verify(phoneNumberRepository).existsByPhoneNumber(phoneNumberDto.getPhoneNumber());
        verify(phoneNumberRepository).save(phoneNumberEntity);
    }

    @Test
    public void testDeletePhoneNumber() {
        int phoneNumberId = 1;
        PhoneNumberEntity phoneNumberEntity = new PhoneNumberEntity();
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();

        phoneNumberDto.setPhoneNumber("1234567890");

        phoneNumberEntity.setPhoneNumberId(phoneNumberId);
        phoneNumberEntity.setPhoneNumber("1234567890");

        when(phoneNumberMapper.toEntity(phoneNumberDto)).thenReturn(phoneNumberEntity);
        when(phoneNumberRepository.existsById(phoneNumberId)).thenReturn(true);

        phoneNumberService.deletePhone(phoneNumberId);

        verify(phoneNumberRepository).deleteById(phoneNumberId);
    }

    @Test
    public void testGetPhoneNumberById() {
        int phoneNumberId = 1;

        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setPhoneNumber("1234567890");

        PhoneNumberEntity phoneNumberEntity = new PhoneNumberEntity();
        phoneNumberEntity.setPhoneNumberId(phoneNumberId);
        phoneNumberEntity.setPhoneNumber("1234567890");

        when(phoneNumberMapper.toEntity(phoneNumberDto)).thenReturn(phoneNumberEntity);
        when(phoneNumberRepository.findById(phoneNumberId)).thenReturn(Optional.of(phoneNumberEntity));

        phoneNumberService.getPhoneNumberById(phoneNumberId);

        verify(phoneNumberRepository).findById(phoneNumberId);
    }

    @Test
    public void testUpdatePhoneNumber() {
        int phoneNumberId = 1;
        PhoneNumberDto phoneNumberDto = Mockito.mock(PhoneNumberDto.class);
        phoneNumberDto.setPhoneNumberId(phoneNumberId);
        phoneNumberDto.setPhoneNumber("1234567890");

        UpdatePhoneNumberRequest updatePhoneNumberRequest = Mockito.mock(UpdatePhoneNumberRequest.class);
        updatePhoneNumberRequest.setPhoneNumber("9876543210");

        PhoneNumberEntity phoneNumberEntity = Mockito.mock(PhoneNumberEntity.class);
        phoneNumberEntity.setPhoneNumber("1234567890");
        phoneNumberEntity.setPhoneNumberId(phoneNumberId);

        PhoneNumberService service = Mockito.mock(PhoneNumberManager.class);


        when(phoneNumberMapper.toEntity(phoneNumberDto)).thenReturn(phoneNumberEntity);
        when(phoneNumberRepository.findById(phoneNumberId)).thenReturn(Optional.of(phoneNumberEntity));

        service.updatePhoneNumber(phoneNumberId, updatePhoneNumberRequest);


        verify(service).updatePhoneNumber(phoneNumberId, updatePhoneNumberRequest);


    }
}