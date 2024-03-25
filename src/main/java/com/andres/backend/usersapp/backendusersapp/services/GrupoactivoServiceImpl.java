package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andres.backend.usersapp.backendusersapp.models.entities.Grupoactivo;
import com.andres.backend.usersapp.backendusersapp.repositories.GrupoactivoRepository;
@Service
public class GrupoactivoServiceImpl implements GrupoactivoService {

	@Autowired
	private GrupoactivoRepository repository;

	@Override
	public List<Grupoactivo> findAll() {
		// TODO Auto-generated method stub
		return (List<Grupoactivo>) repository.findAll();
	}

	@Override
	public Optional<Grupoactivo> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Grupoactivo save(Grupoactivo grupoactivo) {
		return repository.save(grupoactivo);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
