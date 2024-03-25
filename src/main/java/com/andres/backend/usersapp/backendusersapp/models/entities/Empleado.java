package com.andres.backend.usersapp.backendusersapp.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="empleado")
public class Empleado {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long empleado_id;

	    @NotBlank
	    private String nombre;

	    @NotBlank
	    private String domicilio;

	    private String cargo;

	    private String email;

	    private String clave_busqueda;

	    private Long departamento_id;

	    private Long sucursal_id;

		public Long getEmpleado_id() {
			return empleado_id;
		}

		public void setEmpleado_id(Long empleado_id) {
			this.empleado_id = empleado_id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}

		public String getCargo() {
			return cargo;
		}

		public void setCargo(String cargo) {
			this.cargo = cargo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getClave_busqueda() {
			return clave_busqueda;
		}

		public void setClave_busqueda(String clave_busqueda) {
			this.clave_busqueda = clave_busqueda;
		}

		public Long getDepartamento_id() {
			return departamento_id;
		}

		public void setDepartamento_id(Long departamento_id) {
			this.departamento_id = departamento_id;
		}

		public Long getSucursal_id() {
			return sucursal_id;
		}

		public void setSucursal_id(Long sucursal_id) {
			this.sucursal_id = sucursal_id;
		}



}
