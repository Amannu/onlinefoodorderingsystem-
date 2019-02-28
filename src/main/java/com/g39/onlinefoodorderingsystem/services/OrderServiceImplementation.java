package com.g39.onlinefoodorderingsystem.services;

import java.util.Optional;

import com.g39.onlinefoodorderingsystem.domains.Order;
import com.g39.onlinefoodorderingsystem.repositories.OrderRepository;

public class OrderServiceImplementation implements OrderService {
	OrderRepository orderRepository;
	@Override
	public <S extends Order> S save(S entity) {
		entity.setUsername(entity.getUsername());
		entity.setOrder(entity.getOrder());
		entity.setAdress(entity.getAdress());
		entity.setDetails(entity.getDetails());
		entity.setQuantity(entity.getQuantity());
		return orderRepository.save(entity);	}

	@Override
	public <S extends Order> Iterable<S> saveAll(Iterable<S> entities) {
		return orderRepository.saveAll(entities);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Iterable<Order> findAllById(Iterable<Long> ids) {
		return orderRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);

	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		orderRepository.deleteAll(entities);

	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();

	}

}
