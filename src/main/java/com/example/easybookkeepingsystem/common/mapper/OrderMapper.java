package com.example.easybookkeepingsystem.common.mapper;

import com.example.easybookkeepingsystem.domain.order.Order;
import com.example.easybookkeepingsystem.infrastructure.persistence.order.OrderEntity;
import com.example.easybookkeepingsystem.interfaces.bookkeeping.BookkeepingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    BookkeepingResponse.Bookkeeping toBookkeepingResponse(Order order);

    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "orderVersion", source = "version")
    @Mapping(target = "orderDate", source = "orderDate")
    Order fromOrderEntity(OrderEntity orderEntity);
}
