package com.pratheek.orderservice.entity;

import com.pratheek.orderservice.dto.FoodItemsDto;
import com.pratheek.orderservice.dto.Restaurant;
import com.pratheek.orderservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

    private Integer orderId;
    private List<FoodItemsDto> foodItemsList;
    private Restaurant restaurant;
    private UserDto userDto;
}
