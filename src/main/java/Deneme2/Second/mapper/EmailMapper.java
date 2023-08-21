package Deneme2.Second.mapper;

import Deneme2.Second.entities.contact.Email;
import Deneme2.Second.requests.Update.UpdateEmailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel ="spring")
public interface EmailMapper {

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);
    @Mapping(target = "emailId", ignore = true)
    void updateEmailFromRequest(UpdateEmailRequest updateEmailRequest, @MappingTarget Email email);

}
