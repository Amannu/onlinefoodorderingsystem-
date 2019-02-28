package com.g39.onlinefoodorderingsystem.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.g39.onlinefoodorderingsystem.domains.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Long> {
}
