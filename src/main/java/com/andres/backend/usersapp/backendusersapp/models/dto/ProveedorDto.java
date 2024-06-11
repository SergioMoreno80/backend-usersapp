package com.andres.backend.usersapp.backendusersapp.models.dto;

public class ProveedorDto {
	
    private Long proveedor_id;
    private String nombre;
    private String descripcion;
    private String estatus;    
    
	public ProveedorDto(Long proveedor_id, String nombre, String descripcion, String estatus) {
		super();
		this.proveedor_id = proveedor_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estatus = estatus;
	}
	
	public Long getProveedor_id() {
		return proveedor_id;
	}
	public void setProveedor_id(Long proveedor_id) {
		this.proveedor_id = proveedor_id;
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
    
    
    

}
