package com.andres.backend.usersapp.backendusersapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andres.backend.usersapp.backendusersapp.models.dto.MovimientoResponseDto;
import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_inventarioDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_inventario;

public interface MovimientoRepository extends CrudRepository<Movimientos_inventario, Long> {


	Page<Movimientos_inventario> findAll(Pageable pageable);
		    
//    @Query("SELECT new com.example.dto.MovimientoResponseDto(mi.tipo_movimiento, mi.fecha_movimiento, mi.descripcion, mi.documento, p.nombre, s.nombre, e.nombre, d.nombre) FROM Movimientos_Inventario mi " +
//            "JOIN mi.proveedor p " +
//            "JOIN mi.sucursales s " +
//            "JOIN mi.empleado e " +
//            "JOIN e.departamentos d")
//    Page<MovimientoResponseDto> obtenerMovimientos(Pageable pageable);


}
