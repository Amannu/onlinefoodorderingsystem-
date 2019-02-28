package com.g39.onlinefoodorderingsystem.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.g39.onlinefoodorderingsystem.domains.Menu;
import com.g39.onlinefoodorderingsystem.repositories.MenuRepository;

@Service
public class MenuServiceImplementation implements MenuService {
	MenuRepository menuRepository;

	@Override
	public <S extends Menu> S save(S entity) {
		entity.setFoodName(entity.getFoodName());
		entity.setPrice(entity.getPrice());
		return menuRepository.save(entity);
	}

	@Override
	public <S extends Menu> Iterable<S> saveAll(Iterable<S> entities) {
		return menuRepository.saveAll(entities);
	}

	@Override
	public Optional<Menu> findById(Long id) {
		return menuRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return menuRepository.existsById(id);
	}

	@Override
	public Iterable<Menu> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public Iterable<Menu> findAllById(Iterable<Long> ids) {
		return menuRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return menuRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		menuRepository.deleteById(id);
	}

	@Override
	public void delete(Menu entity) {
		menuRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Menu> entities) {
		menuRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		menuRepository.deleteAll();
	}

	
	

}
