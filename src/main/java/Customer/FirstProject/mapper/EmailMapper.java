package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.EmailDto;
import Customer.FirstProject.entities.contact.EmailEntity;
import Customer.FirstProject.requests.Update.UpdateEmailRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel ="spring")
public interface EmailMapper {
    @Mapping(source = "emailId", target = "emailId")
    EmailDto toDto(EmailEntity emailEntity);

    EmailEntity toEntity(EmailDto emailDto);

    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    @Mapping(target = "emailId", ignore = true)
    void updateEmailFromRequest(UpdateEmailRequest updateEmailRequest, @MappingTarget EmailEntity emailEntity);
}
