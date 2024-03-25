package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.andres.backend.usersapp.backendusersapp.models.entities.Departamentos;

public interface DepartamentosService {
	List<Departamentos> findAll();
	Optional<Departamentos> findById(Long id);
	Departamentos save(Departamentos departamentos);
	void remove(Long id);
}
