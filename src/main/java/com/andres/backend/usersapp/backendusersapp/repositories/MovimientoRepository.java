package com.andres.backend.usersapp.backendusersapp.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_inventario;

public interface MovimientoRepository extends CrudRepository<Movimientos_inventario, Long> {

	Page<Movimientos_inventario> findAll(Pageable pageable);

//	  @Query("select m from Movimientos_inventario m left join fetch m.sucursales")
	@Query(value = "select m from Movimientos_inventario m left join fetch m.sucursales", countQuery = "select count(m) from Movimientos_inventario m")
	Page<Movimientos_inventario> obtenerMovimientos(Pageable pageable);

	@Query(value = "select m from Movimientos_inventario m \n"
			+ "JOIN Movimientos_detalle d ON m.id = d.movimiento.id", countQuery = "SELECT count(*) FROM Movimientos_inventario")
	List<Movimientos_inventario> findByActivoId(@Param("activo_id") Long activo_id);

}
