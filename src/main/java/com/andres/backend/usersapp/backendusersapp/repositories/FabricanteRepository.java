package com.andres.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.backend.usersapp.backendusersapp.models.entities.Fabricante;

public interface FabricanteRepository
	extends CrudRepository<Fabricante, Long> {

	//Optional<Fabricante> findByName(String nombre);
}
