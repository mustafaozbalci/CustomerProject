package Deneme2.Second.mapper;

import Deneme2.Second.entities.contact.PhoneNumberEntity;
import Deneme2.Second.requests.Update.UpdatePhoneNumberRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface PhoneNumberMapper {

    PhoneNumberMapper INSTANCE = Mappers.getMapper(PhoneNumberMapper.class);

    @Mapping(target = "phoneNumberId", ignore = true)
    void updatePhoneNumberFromRequest(UpdatePhoneNumberRequest request, @MappingTarget PhoneNumberEntity phoneNumberEntity);

}
