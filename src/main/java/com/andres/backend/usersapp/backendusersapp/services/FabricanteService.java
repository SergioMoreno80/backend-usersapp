package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;
import com.andres.backend.usersapp.backendusersapp.models.dto.FabricanteDto;

public interface FabricanteService {

	List<FabricanteDto> findAll();
	Optional<FabricanteDto> findById(Long id);
	FabricanteDto save(FabricanteDto fabricante);
	Optional<FabricanteDto> update(FabricanteDto fabricante, Long id);
	void remove(Long id);
}
