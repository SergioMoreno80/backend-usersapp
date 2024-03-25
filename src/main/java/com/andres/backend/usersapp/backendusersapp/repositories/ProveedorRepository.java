package com.andres.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;

public interface ProveedorRepository
extends CrudRepository<Proveedor, Long> {

    //Optional<Proveedor> findByName(String nombre);
	//Page<Proveedor> findAll(Pageable pageable);

}


