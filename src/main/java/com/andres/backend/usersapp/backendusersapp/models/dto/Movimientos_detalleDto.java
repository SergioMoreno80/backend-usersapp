package com.andres.backend.usersapp.backendusersapp.models.dto;

public class Movimientos_detalleDto {

	private Long id;
	private Long movimiento_id;
    private Long activo_id;
    private Long cantidad;
    



	public Movimientos_detalleDto(Long id, Long movimiento_id, Long activo_id, Long cantidad) {
		super();
		this.id = id;
		this.movimiento_id = movimiento_id;
		this.activo_id = activo_id;
		this.cantidad = cantidad;
	}


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
