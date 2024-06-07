package com.andres.backend.usersapp.backendusersapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_detalleDto;
import com.andres.backend.usersapp.backendusersapp.models.dto.mapper.DtoMapperMovimientoDet;
import com.andres.backend.usersapp.backendusersapp.models.entities.Activo;
import com.andres.backend.usersapp.backendusersapp.models.entities.Departamentos;
import com.andres.backend.usersapp.backendusersapp.models.entities.Empleado;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_detalle;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_inventario;
import com.andres.backend.usersapp.backendusersapp.models.entities.Sucursales;
import com.andres.backend.usersapp.backendusersapp.repositories.ActivoRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.MovimientoDetRepository;
import com.andres.backend.usersapp.backendusersapp.repositories.MovimientoRepository;

@Service
public class MovimientoDetServiceImpl implements MovimientoDetService {


	@Autowired
	private MovimientoDetRepository repository;
	
	@Autowired
	private MovimientoRepository MovRepository;
	@Autowired
	private ActivoRepository ActivoRep;

	@Override
	@Transactional(readOnly = true)
	public List<Movimientos_detalleDto> findAll() {

		List<Movimientos_detalle> detalles = (List<Movimientos_detalle>) repository.findAll();
		return detalles.stream().map(u -> DtoMapperMovimientoDet.builder().setMovimientoDet(u).build())
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Movimientos_detalleDto> findAll(Pageable pageable) {
		return repository.findAll(pageable).map(u -> DtoMapperMovimientoDet.builder().setMovimientoDet(u).build());
		}

	@Override
	@Transactional(readOnly = true)
	public Optional<Movimientos_detalleDto> findById(Long id) {
		return repository.findById(id).map(u -> DtoMapperMovimientoDet.builder().setMovimientoDet(u).build());

		}

	@Override
	@Transactional
	public Movimientos_detalleDto save(Movimientos_detalleDto detalle) {

		Movimientos_detalle MovDb = new Movimientos_detalle();
		Optional<Movimientos_inventario> optionalMovimiento = MovRepository.findById(Long.valueOf(detalle.getMovimiento_id()));
		Optional<Activo> optionalActivo = ActivoRep.findById(Long.valueOf(detalle.getActivo_id()));

		MovDb.setMovimiento(optionalMovimiento.get());
		MovDb.setActivo(optionalActivo.get());
		MovDb.setCantidad(detalle.getCantidad());

		return DtoMapperMovimientoDet.builder().setMovimientoDet(repository.save(MovDb)).build();

	}

	@Override
	@Transactional
	public Optional<Movimientos_detalleDto> update(Movimientos_detalleDto detalle, Long id) {

		Optional<Movimientos_detalle> o = repository.findById(id);

		Movimientos_detalle movOptional = null;
		if (o.isPresent()) {
			Movimientos_detalle MovDb = o.orElseThrow();
			Optional<Movimientos_inventario> optionalMovimiento = MovRepository.findById(Long.valueOf(detalle.getMovimiento_id()));
			Optional<Activo> optionalActivo = ActivoRep.findById(Long.valueOf(detalle.getActivo_id()));
			MovDb.setMovimiento(optionalMovimiento.get());
			MovDb.setActivo(optionalActivo.get());
			MovDb.setCantidad(detalle.getCantidad());


			movOptional = repository.save(MovDb);
		}
		return Optional.ofNullable(DtoMapperMovimientoDet.builder().setMovimientoDet(movOptional).build());
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
		}



}
