package com.andres.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "grupoactivo")
public class Grupoactivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grupoactivo_id;

	@Column(unique = true)
	private String nombre;
	@NotBlank
	private String descripcion;
	@NotBlank
	private String estatus;
	@NotBlank
	private String clave_busqueda;

	public Long getGrupoactivo_id() {
		return grupoactivo_id;
	}
	public void setGrupoactivo_id(Long grupoactivo_id) {
		this.grupoactivo_id = grupoactivo_id;
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
