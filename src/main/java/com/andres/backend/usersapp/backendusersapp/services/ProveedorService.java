package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;

public interface ProveedorService {


	List<Proveedor> findAll();
	Optional<Proveedor> findById(Long id);

	Proveedor save(Proveedor proveedor);

	void remove(Long id);


}
