package com.andres.backend.usersapp.backendusersapp.models.dto.mapper;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_detalleDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_detalle;

public class DtoMapperMovimientoDet {


	private Movimientos_detalle detalle;

	private DtoMapperMovimientoDet() {
	}

	public static DtoMapperMovimientoDet builder() {
		return new DtoMapperMovimientoDet();
	}

	public DtoMapperMovimientoDet setMovimientoDet(Movimientos_detalle detalle) {
		this.detalle = detalle;
		return this;
	}

	public Movimientos_detalleDto build() {
		if (detalle == null) {
			throw new RuntimeException("Debe pasar el entity detalle de mov!");
		}

		// boolean isAdmin = user.getRoles().stream().anyMatch(r ->
		// "ROLE_ADMIN".equals(r.getName()));
		return new Movimientos_detalleDto
				(detalle.getId(),
						detalle.getMovimiento_id(),
						detalle.getActivo_id(),
						detalle.getCantidad());
	}


}
