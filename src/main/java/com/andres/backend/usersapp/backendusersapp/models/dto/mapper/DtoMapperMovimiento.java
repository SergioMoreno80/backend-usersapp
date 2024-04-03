package com.andres.backend.usersapp.backendusersapp.models.dto.mapper;

import com.andres.backend.usersapp.backendusersapp.models.dto.Movimientos_inventarioDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Movimientos_inventario;

public class DtoMapperMovimiento {

	private Movimientos_inventario movimiento;

	private DtoMapperMovimiento() {
	}

	public static DtoMapperMovimiento builder() {
		return new DtoMapperMovimiento();
	}

	public DtoMapperMovimiento setMovimiento(Movimientos_inventario movimiento) {
		this.movimiento = movimiento;
		return this;
	}

	public Movimientos_inventarioDto build() {
		if (movimiento == null) {
			throw new RuntimeException("Debe pasar el entity movimiento!");
		}

		// boolean isAdmin = user.getRoles().stream().anyMatch(r ->
		// "ROLE_ADMIN".equals(r.getName()));
		return new Movimientos_inventarioDto(movimiento.getId(), movimiento.getTipo_movimiento(),
				movimiento.getFecha_movimiento(), movimiento.getDescripcion(), movimiento.getSucursales().getNombre(),
				movimiento.getDepartamentos().getNombre(), movimiento.getEmpleado().getNombre(), movimiento.getUser_id(),
				movimiento.getDocumento());
	}



}
