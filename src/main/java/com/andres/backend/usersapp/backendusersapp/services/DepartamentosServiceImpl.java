package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.backend.usersapp.backendusersapp.models.entities.Departamentos;
import com.andres.backend.usersapp.backendusersapp.repositories.DepartamentosRepository;

@Service
public class DepartamentosServiceImpl implements DepartamentosService{


	@Autowired
	private DepartamentosRepository repository;

	@Override
	public List<Departamentos> findAll() {
		// TODO Auto-generated method stub
		return (List<Departamentos>) repository.findAll();
	}

	@Override
	public Optional<Departamentos> findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Departamentos save(Departamentos departamentos) {
		// TODO Auto-generated method stub
		return repository.save(departamentos);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);

	}

}
