package com.g39.onlinefoodorderingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.g39.onlinefoodorderingsystem.domains.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
