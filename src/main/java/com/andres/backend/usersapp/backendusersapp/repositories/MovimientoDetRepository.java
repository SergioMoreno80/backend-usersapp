package com.andres.backend.usersapp.backendusersapp.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_detalle;

public interface MovimientoDetRepository extends CrudRepository<Movimientos_detalle, Long> {

	Page<Movimientos_detalle> findAll(Pageable pageable);
    List<Movimientos_detalle> findByActivo(Long activo_id);

}
