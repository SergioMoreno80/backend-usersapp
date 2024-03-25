package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.andres.backend.usersapp.backendusersapp.models.dto.ActivoDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;

public interface ActivoService {

	List<ActivoDto> findAll();
	Page<ActivoDto> findAll(Pageable pageable);

    Page<Object[]> findAllActivosWithFabricanteAndProveedor(Pageable pageable);

	Optional<ActivoDto> findById(Long id);
	ActivoDto save(ActivoDto activo);
	ActivoDto saveWithImage(Activo activo, MultipartFile imagen);

	Optional<ActivoDto> update(ActivoDto activo, Long id);
	void remove(Long id);

}
