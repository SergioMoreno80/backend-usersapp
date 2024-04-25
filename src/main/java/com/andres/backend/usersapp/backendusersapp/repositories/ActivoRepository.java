package com.andres.backend.usersapp.backendusersapp.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.andres.backend.usersapp.backendusersapp.models.dto.ActivoDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;

public interface ActivoRepository extends CrudRepository<Activo, Long> {

	Page<Activo> findAll(Pageable pageable);
    //List<Activo> listarActivos();
	//List<Activo> findAll();


	@Query(
			  value = "SELECT a.activo_id, a.foto, a.nombre, a.factura, a.fecha_compra, \n"
			  		+ "a.importe, p.nombre AS nombre_proveedor, a.estatus,a.no_serie,\n"
			  		+ "f.nombre AS nombre_fabricante \n"
			  		+ "FROM activo a \n"
			  		+ "JOIN fabricante f ON a.fabricante_id = f.fabricante_id \n"
			  		+ "JOIN proveedor p ON p.proveedor_id = a.proveedor_id",
			  countQuery = "SELECT count(*) FROM activo",
			  nativeQuery = true)
	    Page<Object[]> findAllActivosWithFabricanteAndProveedor(Pageable pageable);


}
