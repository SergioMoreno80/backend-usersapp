package com.andres.backend.usersapp.backendusersapp.models.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="movimientos_inventario")
public class Movimientos_inventario {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotBlank
	    private String tipo_movimiento;
	    @NotNull
	    private Date fecha_movimiento;
	    @NotBlank
	    private String descripcion;

	    @NotNull
	    private Long id_sucursal;

//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "id_sucursal", referencedColumnName = "id")
//	    private Sucursales sucursales;

	    @NotNull
	    private Long id_departamento;

//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
//	    private Departamentos departamentos;

	    @NotNull
	    private Long empleado_id;

//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "empleado_id", referencedColumnName = "empleado_id")
//	    private Empleado empleado;

	    private Long user_id;
//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name = "user_id", referencedColumnName = "id")
//	    private User user;

	    private byte[] doc; // Columna para almacenar la imagen en formato de bytes

	    private String documento;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTipo_movimiento() {
			return tipo_movimiento;
		}

		public void setTipo_movimiento(String tipo_movimiento) {
			this.tipo_movimiento = tipo_movimiento;
		}

		public Date getFecha_movimiento() {
			return fecha_movimiento;
		}

		public void setFecha_movimiento(Date fecha_movimiento) {
			this.fecha_movimiento = fecha_movimiento;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public Long getId_sucursal() {
			return id_sucursal;
		}

		public void setId_sucursal(Long id_sucursal) {
			this.id_sucursal = id_sucursal;
		}

		public Long getId_departamento() {
			return id_departamento;
		}

		public void setId_departamento(Long id_departamento) {
			this.id_departamento = id_departamento;
		}

		public Long getEmpleado_id() {
			return empleado_id;
		}

		public void setEmpleado_id(Long empleado_id) {
			this.empleado_id = empleado_id;
		}

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public byte[] getDoc() {
			return doc;
		}

		public void setDoc(byte[] doc) {
			this.doc = doc;
		}

//		public Sucursales getSucursales() {
//			return sucursales;
//		}
//
//		public void setSucursales(Sucursales sucursales) {
//			this.sucursales = sucursales;
//		}
//
//		public Departamentos getDepartamentos() {
//			return departamentos;
//		}
//
//		public void setDepartamentos(Departamentos departamentos) {
//			this.departamentos = departamentos;
//		}
//
//		public Empleado getEmpleado() {
//			return empleado;
//		}
//
//		public void setEmpleado(Empleado empleado) {
//			this.empleado = empleado;
//		}
//
//		public User getUser() {
//			return user;
//		}
//
//		public void setUser(User user) {
//			this.user = user;
//		}








}
