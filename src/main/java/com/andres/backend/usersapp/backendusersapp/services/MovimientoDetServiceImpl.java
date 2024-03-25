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
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_detalle;
import com.andres.backend.usersapp.backendusersapp.repositories.MovimientoDetRepository;

@Service
public class MovimientoDetServiceImpl implements MovimientoDetService {


	@Autowired
	private MovimientoDetRepository repository;

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

		MovDb.setMovimiento_id(detalle.getMovimiento_id());

		MovDb.setActivo_id(detalle.getActivo_id());
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
			MovDb.setMovimiento_id(detalle.getMovimiento_id());
			MovDb.setActivo_id(detalle.getActivo_id());
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
