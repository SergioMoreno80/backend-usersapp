package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.backend.usersapp.backendusersapp.models.entities.Sucursales;
import com.andres.backend.usersapp.backendusersapp.repositories.SucursalesRepository;

@Service
public class SucursalesServiceImpl implements SucursalesService{
	@Autowired
	private SucursalesRepository repository;

	@Override
	public List<Sucursales> findAll() {
		// TODO Auto-generated method stub
		return (List<Sucursales>) repository.findAll();
	}

	@Override
	public Optional<Sucursales> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Sucursales save(Sucursales sucursales) {
		// TODO Auto-generated method stub
		return repository.save(sucursales);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);

	}

}
