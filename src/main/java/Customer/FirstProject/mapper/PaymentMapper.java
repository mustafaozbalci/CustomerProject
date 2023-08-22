package Customer.FirstProject.mapper;

import Customer.FirstProject.entities.payment.PaymentEntity;
import Customer.FirstProject.requests.Update.UpdatePaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    @Mapping(target = "paymentId" , ignore = true)
    void UpdatePaymentByRequest(UpdatePaymentRequest updatePaymentRequest, @MappingTarget PaymentEntity paymentEntity);
}
