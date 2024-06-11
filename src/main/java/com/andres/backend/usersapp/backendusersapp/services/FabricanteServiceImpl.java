package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.backend.usersapp.backendusersapp.models.dto.FabricanteDto;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperActivo;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperFabricante;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperProveedor;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;
import com.andres.backend.usersapp.backendusersapp.models.entities.Fabricante;
import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;
import com.andres.backend.usersapp.backendusersapp.repositories.FabricanteRepository;

@Service
public class FabricanteServiceImpl implements FabricanteService {

	@Autowired
	private FabricanteRepository repository;

	@Override
	public List<FabricanteDto> findAll() {
		List<Fabricante> fabricante = (List<Fabricante>) repository.findAll();
		return fabricante.stream().map(u -> DtoMapperFabricante.builder().
				setFabricante(u).build()).collect(Collectors.toList());		
	}

	@Override
	public Optional<FabricanteDto> findById(Long id) {
		return repository.findById(id).map(u -> DtoMapperFabricante.builder().setFabricante(u).build());
	}

	@Override
	@Transactional
	public FabricanteDto save(FabricanteDto fabricante) {
		Fabricante newDb = new Fabricante();
		newDb.setNombre(fabricante.getNombre());
		newDb.setDescripcion(fabricante.getDescripcion());
		newDb.setEstatus("A");
		newDb.setClave_busqueda(fabricante.getClave_busqueda());
		return DtoMapperFabricante.builder().setFabricante(repository.save(newDb)).build();	
		}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public Optional<FabricanteDto> update(FabricanteDto fabricante, Long id) {
		Optional<Fabricante> o = repository.findById(id);
		Fabricante fabOptional = null;

		if (o.isPresent()) {
			Fabricante newDb =  o.orElseThrow();
			newDb.setNombre(fabricante.getNombre());
			newDb.setDescripcion(fabricante.getDescripcion());
			newDb.setEstatus(fabricante.getEstatus());
			newDb.setClave_busqueda(fabricante.getClave_busqueda());
			fabOptional = repository.save(newDb);

		}
		
		return Optional.ofNullable(DtoMapperFabricante.builder().setFabricante(fabOptional).build());
	}

}
