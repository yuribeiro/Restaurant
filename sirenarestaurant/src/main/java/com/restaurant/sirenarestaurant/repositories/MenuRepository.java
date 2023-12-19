package com.restaurant.sirenarestaurant.repositories;

import com.restaurant.sirenarestaurant.entities.MenuItem;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<MenuItem, Integer> {

    // Return list items by category
    List<MenuItem> findByCategory(String category);
    Optional<MenuItem> findByItem(String item);
    
}
