package com.andres.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.backend.usersapp.backendusersapp.models.entities.Grupoactivo;

public interface GrupoactivoRepository
extends CrudRepository<Grupoactivo, Long> {
   // Optional<Grupoactivo> findByName(String nombre);

}
