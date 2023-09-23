package com.pratheek.orderservice.service;

import com.pratheek.orderservice.dto.OrderDto;
import com.pratheek.orderservice.dto.OrderDtoFromFE;
import com.pratheek.orderservice.dto.UserDto;
import com.pratheek.orderservice.entity.Order;
import com.pratheek.orderservice.mapper.OrderMapper;
import com.pratheek.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private SequenceGenerator generator;
    @Autowired
    private RestTemplate restTemplate;

    public OrderDto saveOrderInDb(OrderDtoFromFE orderDetails) {
        Integer newOrderId = generator.generateNextOrderId();
        UserDto userDto = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(),orderDetails.getRestaurant(),userDto);
        repository.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDto(orderToBeSaved);
    }

    private UserDto fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDto.class);
    }
}
