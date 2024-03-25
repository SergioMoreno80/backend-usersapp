package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.andres.backend.usersapp.backendusersapp.models.entities.Grupoactivo;

public interface GrupoactivoService {

	List<Grupoactivo> findAll();

	Optional<Grupoactivo> findById(Long id);

	Grupoactivo save(Grupoactivo grupoactivo);

	void remove(Long id);
}
