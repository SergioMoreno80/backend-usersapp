package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.backend.usersapp.backendusersapp.models.dto.ProveedorDto;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperActivo;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperFabricante;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperProveedor;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;
import com.andres.backend.usersapp.backendusersapp.models.entities.Fabricante;
import com.andres.backend.usersapp.backendusersapp.models.entities.Proveedor;
import com.andres.backend.usersapp.backendusersapp.repositories.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<ProveedorDto> findAll() {
		List<Proveedor> proveedor = (List<Proveedor>) repository.findAll();
		return proveedor.stream().map(u -> DtoMapperProveedor.builder().
				setProveedor(u).build()).collect(Collectors.toList());
	}

	@Override
	public Optional<ProveedorDto> findById(Long id) {
		return repository.findById(id).map(u -> DtoMapperProveedor.builder().setProveedor(u).build());
	}

	@Override
	@Transactional
	public ProveedorDto save(ProveedorDto proveedor) {
		Proveedor proveedorDb = new Proveedor();
		proveedorDb.setNombre(proveedor.getNombre());
		proveedorDb.setDescripcion(proveedor.getDescripcion());
		proveedorDb.setEstatus("A");
		return DtoMapperProveedor.builder().setProveedor(repository.save(proveedorDb)).build();
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<ProveedorDto> update(ProveedorDto proveedor, Long id) {

		Optional<Proveedor> o = repository.findById(id);
		Proveedor fabOptional = null;

		if (o.isPresent()) {
			Proveedor newDb =  o.orElseThrow();
			newDb.setNombre(proveedor.getNombre());
			newDb.setDescripcion(proveedor.getDescripcion());
			newDb.setEstatus(proveedor.getEstatus());
			fabOptional = repository.save(newDb);

		}
		
		return Optional.ofNullable(DtoMapperProveedor.builder().setProveedor(fabOptional).build());
	
	}

}
