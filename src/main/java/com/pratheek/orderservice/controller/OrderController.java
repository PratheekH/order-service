package com.pratheek.orderservice.controller;

import com.pratheek.orderservice.dto.OrderDto;
import com.pratheek.orderservice.dto.OrderDtoFromFE;
import com.pratheek.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDto> saveOrder(@RequestBody OrderDtoFromFE orderDetails){
        OrderDto orderSavedInDb = orderService.saveOrderInDb(orderDetails);
        return new ResponseEntity<>(orderSavedInDb, HttpStatus.CREATED);
    }
}
