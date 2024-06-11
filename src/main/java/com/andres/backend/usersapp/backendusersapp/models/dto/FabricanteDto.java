package com.andres.backend.usersapp.backendusersapp.models.dto;

public class FabricanteDto {
	private Long fabricante_id;
	private String nombre;
	private String descripcion;
	private String estatus;
	private String clave_busqueda;
	
	
	
	public FabricanteDto(Long fabricante_id, String nombre, String descripcion, String estatus, String clave_busqueda) {
		super();
		this.fabricante_id = fabricante_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.clave_busqueda = clave_busqueda;
	}
	public Long getFabricante_id() {
		return fabricante_id;
	}
	public void setFabricante_id(Long fabricante_id) {
		this.fabricante_id = fabricante_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getClave_busqueda() {
		return clave_busqueda;
	}
	public void setClave_busqueda(String clave_busqueda) {
		this.clave_busqueda = clave_busqueda;
	}

	
	
	
}
