package com.andres.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.backend.usersapp.backendusersapp.models.entities.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

}
