package com.pratheek.orderservice.mapper;

import com.pratheek.orderservice.dto.OrderDto;
import com.pratheek.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto mapOrderToOrderDto(Order order);
    Order mapOrderDtoToOrder(OrderDto orderDto);
}
