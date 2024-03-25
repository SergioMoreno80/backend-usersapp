package com.andres.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="movimientos_detalle")
public class Movimientos_detalle {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
	private Long movimiento_id;

    @NotNull
    private Long activo_id;

    @NotNull
    private Long cantidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovimiento_id() {
		return movimiento_id;
	}

	public void setMovimiento_id(Long movimiento_id) {
		this.movimiento_id = movimiento_id;
	}

	public Long getActivo_id() {
		return activo_id;
	}

	public void setActivo_id(Long activo_id) {
		this.activo_id = activo_id;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}



}
