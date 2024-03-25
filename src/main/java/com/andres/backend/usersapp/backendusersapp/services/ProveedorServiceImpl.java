package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;
import com.andres.backend.usersapp.backendusersapp.repositories.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<Proveedor> findAll() {
		return (List<Proveedor>) repository.findAll();
	}

	@Override
	public Optional<Proveedor> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Proveedor save(Proveedor proveedor) {
		return repository.save(proveedor);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
