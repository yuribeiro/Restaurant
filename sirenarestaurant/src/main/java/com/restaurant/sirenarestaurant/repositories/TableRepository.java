package com.restaurant.sirenarestaurant.repositories;

import com.restaurant.sirenarestaurant.entities.TableOrder;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<TableOrder, Integer>{
    
}
