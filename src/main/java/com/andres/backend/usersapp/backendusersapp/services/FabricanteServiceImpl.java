package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.backend.usersapp.backendusersapp.models.entities.Fabricante;
import com.andres.backend.usersapp.backendusersapp.repositories.FabricanteRepository;

@Service
public class FabricanteServiceImpl implements FabricanteService {

	@Autowired
	private FabricanteRepository repository;

	@Override
	public List<Fabricante> findAll() {
		// TODO Auto-generated method stub
		return (List<Fabricante>) repository.findAll();
	}

	@Override
	public Optional<Fabricante> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Fabricante save(Fabricante fabricante) {
		return repository.save(fabricante);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
