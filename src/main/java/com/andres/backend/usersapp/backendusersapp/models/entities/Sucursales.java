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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="sucursales")
public class Sucursales {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotBlank
		private String nombre;

		private String direccion;

		private String ciudad;

		private String codigo_postal;

		private String pais;

		private String telefono;
	    @NotNull
		private Long encargado_id;


	    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="sucursales")
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
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public String getCodigo_postal() {
			return codigo_postal;
		}
		public void setCodigo_postal(String codigo_postal) {
			this.codigo_postal = codigo_postal;
		}
		public String getPais() {
			return pais;
		}
		public void setPais(String pais) {
			this.pais = pais;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public Long getEncargado_id() {
			return encargado_id;
		}
		public void setEncargado_id(Long encargado_id) {
			this.encargado_id = encargado_id;
		}
		@Override
		public String toString() {
			return "{id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad
					+ ", codigo_postal=" + codigo_postal + ", pais=" + pais + ", telefono=" + telefono
					+ ", encargado_id=" + encargado_id + ", movimientos=" + movimientos + "}";
		}
		
		
//		public Set<Movimientos_inventario> getMovimientos() {
//			return movimientos;
//		}
//		public void setMovimientos(Set<Movimientos_inventario> movimientos) {
//			this.movimientos = movimientos;
//		}



}
