package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.PhoneNumberDto;
import Customer.FirstProject.entities.contact.PhoneNumberEntity;
import Customer.FirstProject.requests.Update.UpdatePhoneNumberRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PhoneNumberMapper {
    @Mapping(target = "phoneNumberId", source = "phoneNumberId")
    PhoneNumberDto toDto (PhoneNumberEntity phoneNumberEntity);

    PhoneNumberEntity toEntity(PhoneNumberDto phoneNumberDto);

    PhoneNumberMapper INSTANCE = Mappers.getMapper(PhoneNumberMapper.class);

    @Mapping(target = "phoneNumberId", ignore = true)
    void UpdatePhoneNumberByRequest(UpdatePhoneNumberRequest updatePhoneNumberRequest, @MappingTarget PhoneNumberEntity phoneNumberEntity);

}
