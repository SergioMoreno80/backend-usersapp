package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.andres.backend.usersapp.backendusersapp.models.entities.Fabricante;


public interface FabricanteService {

	List<Fabricante> findAll();

	Optional<Fabricante> findById(Long id);

	Fabricante save(Fabricante fabricante);

	void remove(Long id);
}
