package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.andres.backend.usersapp.backendusersapp.models.entities.Sucursales;

public interface SucursalesService {
	List<Sucursales> findAll();
	Optional<Sucursales> findById(Long id);
	Sucursales save(Sucursales sucursales);
	void remove(Long id);
}
