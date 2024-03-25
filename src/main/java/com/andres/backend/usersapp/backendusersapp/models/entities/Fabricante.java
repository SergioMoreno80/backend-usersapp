package com.andres.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "fabricante")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fabricante_id;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;
	@NotBlank
    @Column(name = "estatus")
	private String estatus;
	@NotBlank
	@Column(name = "clave_busqueda")
	private String clave_busqueda;

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
