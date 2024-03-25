package com.andres.backend.usersapp.backendusersapp.models.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class Movimientos_inventarioDto {

	 	private Long id;
	    private String tipo_movimiento;
	    private Date fecha_movimiento;
	    private String descripcion;
	    private Long id_sucursal;
//	    private Sucursales sucursales; // Cambiado de Long a Sucursales
//	    private Departamentos departamentos;
//	    private Empleado empleado;
//	    private User user;
	    private Long id_departamento;
	    private Long empleado_id;
	    private Long user_id;
	    private MultipartFile doc; // Columna para almacenar la imagen en formato de bytes
	    private String documento;

		public Movimientos_inventarioDto(Long id, String tipo_movimiento, Date fecha_movimiento, String descripcion,
				Long id_sucursal, Long id_departamento, Long empleado_id, Long user_id,
//				Sucursales sucursales, Departamentos departamentos, Empleado empleado, User user,
//				MultipartFile doc,
				String documento) {
			super();
			this.id = id;
			this.tipo_movimiento = tipo_movimiento;
			this.fecha_movimiento = fecha_movimiento;
			this.descripcion = descripcion;
//	        this.sucursales = sucursales;
//	        this.departamentos = departamentos;
//	        this.empleado = empleado;
//	        this.user = user;
			this.id_sucursal = id_sucursal;

			this.id_departamento = id_departamento;
			this.empleado_id = empleado_id;
			this.user_id = user_id;
			this.doc = doc;
			this.documento = documento;
		}


		public MultipartFile getDoc() {
			return doc;
		}

		public void setDoc(MultipartFile doc) {
			this.doc = doc;
		}

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
//





}
