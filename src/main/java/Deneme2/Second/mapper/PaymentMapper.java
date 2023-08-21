package Deneme2.Second.mapper;

import Deneme2.Second.entities.payment.PaymentEntity;
import Deneme2.Second.requests.Update.UpdatePaymentRequest;
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
