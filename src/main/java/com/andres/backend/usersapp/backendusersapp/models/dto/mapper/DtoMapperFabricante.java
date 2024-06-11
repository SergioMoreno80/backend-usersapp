package com.andres.backend.usersapp.backendusersapp.models.dto.mapper;

import com.andres.backend.usersapp.backendusersapp.models.dto.FabricanteDto;
import com.andres.backend.usersapp.backendusersapp.models.entities.Fabricante;

public class DtoMapperFabricante {

	private Fabricante fabricante;

	private DtoMapperFabricante() {
	}

	public static DtoMapperFabricante builder() {
		return new DtoMapperFabricante();
	}

	public DtoMapperFabricante setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
		return this;
	}

	public FabricanteDto build() {
		if (fabricante == null) {
			throw new RuntimeException("Debe pasar el entity !");
		}
		// boolean isAdmin = user.getRoles().stream().anyMatch(r ->
		// "ROLE_ADMIN".equals(r.getName()));
		return new FabricanteDto(this.fabricante.getFabricante_id(), fabricante.getNombre(),
				fabricante.getDescripcion(), fabricante.getEstatus(), // ,
				fabricante.getClave_busqueda());

	}

}
