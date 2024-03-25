package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_detalleDto;

public interface MovimientoDetService {


	List<Movimientos_detalleDto> findAll();
	Page<Movimientos_detalleDto> findAll(Pageable pageable);

	Optional<Movimientos_detalleDto> findById(Long id);
	Movimientos_detalleDto save(Movimientos_detalleDto detalle);

	Optional<Movimientos_detalleDto> update(Movimientos_detalleDto detalle, Long id);
	void remove(Long id);
}
