package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_inventarioDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_inventario;

public interface MovimientoService {

	List<Movimientos_inventarioDto> findAll();
	Page<Movimientos_inventarioDto> findAll(Pageable pageable);

	Page<Movimientos_inventarioDto> obtenerMovimientos(Pageable pageable);


	Optional<Movimientos_inventarioDto> findById(Long id);
	Movimientos_inventarioDto save(Movimientos_inventarioDto movimiento);

	Optional<Movimientos_inventarioDto> update(Movimientos_inventarioDto movimiento, Long id);
	void remove(Long id);

    List<Movimientos_inventario> findByActivoId(Long activoId);

}
