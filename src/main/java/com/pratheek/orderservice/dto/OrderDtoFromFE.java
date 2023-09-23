package com.pratheek.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoFromFE {


    private List<FoodItemsDto> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;

}
