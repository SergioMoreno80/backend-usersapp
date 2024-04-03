package com.andres.backend.usersapp.backendusersapp.models.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="departamentos")
public class Departamentos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
	private String nombre;

    private String descripcion;

    private Long supervisor_id;
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="departamentos")
    private Set<Movimientos_inventario> movimientos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getSupervisor_id() {
		return supervisor_id;
	}

	public void setSupervisor_id(Long supervisor_id) {
		this.supervisor_id = supervisor_id;
	}




}
