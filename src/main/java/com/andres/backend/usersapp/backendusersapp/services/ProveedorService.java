package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;
import com.andres.backend.usersapp.backendusersapp.models.dto.ProveedorDto;

public interface ProveedorService {

	List<ProveedorDto> findAll();
	Optional<ProveedorDto> findById(Long id);
	ProveedorDto save(ProveedorDto proveedor);
	Optional<ProveedorDto> update(ProveedorDto proveedor, Long id);
	void remove(Long id);

}
