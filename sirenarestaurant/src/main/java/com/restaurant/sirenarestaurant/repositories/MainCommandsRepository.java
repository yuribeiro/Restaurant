package com.restaurant.sirenarestaurant.repositories;

import com.restaurant.sirenarestaurant.entities.MainCommands;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MainCommandsRepository extends CrudRepository<MainCommands, Integer> {
    List<MainCommands> getListByType(String type);
}
