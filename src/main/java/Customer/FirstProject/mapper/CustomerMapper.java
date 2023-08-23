package Customer.FirstProject.mapper;

import Customer.FirstProject.Dto.CustomerDto;
import Customer.FirstProject.entities.customer.CustomerEntity;
import Customer.FirstProject.requests.Update.UpdateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CustomerMapper {


    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    @Mapping(target = "customerId", source = "customerId")
    CustomerDto modelToDto(CustomerEntity customerEntity);

    CustomerEntity dtoToModel(CustomerDto customerDto);




    @Mapping(target = "customerId", ignore = true)
    void updateCustomerFromRequest(UpdateCustomerRequest request, @MappingTarget CustomerEntity customerEntity);
}