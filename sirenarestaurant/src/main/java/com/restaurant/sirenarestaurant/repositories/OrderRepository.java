package com.restaurant.sirenarestaurant.repositories;

import com.restaurant.sirenarestaurant.entities.Order;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer>{
    List<Order> getListByNumberTable(Integer numberTable);
}
