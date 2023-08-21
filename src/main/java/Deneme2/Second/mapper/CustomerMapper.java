package Deneme2.Second.mapper;

import Deneme2.Second.entities.customer.CustomerEntity;
import Deneme2.Second.requests.Update.UpdateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "customerId", ignore = true)
    void updateCustomerFromRequest(UpdateCustomerRequest request, @MappingTarget CustomerEntity customerEntity);
}