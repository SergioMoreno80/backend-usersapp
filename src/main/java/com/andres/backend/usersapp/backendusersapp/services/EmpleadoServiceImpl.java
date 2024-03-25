package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.backend.usersapp.backendusersapp.models.entities.Empleado;
import com.andres.backend.usersapp.backendusersapp.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{


	@Autowired
	private EmpleadoRepository repository;

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>) repository.findAll();
	}

	@Override
	public Optional<Empleado> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return repository.save(empleado);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}


}
