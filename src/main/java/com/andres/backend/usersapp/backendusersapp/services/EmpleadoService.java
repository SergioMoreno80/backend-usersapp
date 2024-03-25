package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import com.andres.backend.usersapp.backendusersapp.models.entities.Empleado;

public interface EmpleadoService {
	List<Empleado> findAll();
	Optional<Empleado> findById(Long id);
	Empleado save(Empleado proveedor);
	void remove(Long id);
}
