package com.andres.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "configuracion")
public class Configuracion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
	@NotBlank
	@Column(name = "local")
	private boolean local;
	
	@NotBlank
	@Column(name = "ruta_imagen")
	private String ruta_imagen;
	
	@NotBlank
	@Column(name = "ruta_docs")
	private String ruta_docs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
	}

	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	public String getRuta_docs() {
		return ruta_docs;
	}

	public void setRuta_docs(String ruta_docs) {
		this.ruta_docs = ruta_docs;
	}
	
	
	
	
}
