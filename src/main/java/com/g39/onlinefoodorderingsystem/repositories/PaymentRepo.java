package com.g39.onlinefoodorderingsystem.repositories;

import org.springframework.data.repository.CrudRepository;

import com.g39.onlinefoodorderingsystem.domains.Payment;

public interface PaymentRepo extends CrudRepository<Payment, Long> {

}
