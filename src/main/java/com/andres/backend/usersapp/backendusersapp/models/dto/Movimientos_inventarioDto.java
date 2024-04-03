package com.andres.backend.usersapp.backendusersapp.models.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.andres.backend.usersapp.backendusersapp.models.entities.Sucursales;


public class Movimientos_inventarioDto {

	 	private Long id;
	    private String tipo_movimiento;
	    private Date fecha_movimiento;
	    private String descripcion;
	   // private Long id_sucursal;
//	    private Sucursales sucursales; // Cambiado de Long a Sucursales
	    private String id_sucursal; // Nombre de la sucursal en lugar de la entidad completa

//	    private Departamentos departamentos;
//	    private Empleado empleado;
//	    private User user;
	    private String id_departamento;
	    private String empleado_id;
	    private Long user_id;
	    private MultipartFile doc; // Columna para almacenar la imagen en formato de bytes
	    private String documento;

		public Movimientos_inventarioDto(Long id, String tipo_movimiento, Date fecha_movimiento, String descripcion,
//				Sucursales sucursales, 
				String id_sucursal, String id_departamento,
				String empleado_id, Long user_id,
				//Long id_sucursal,
				
//				Departamentos departamentos, Empleado empleado, User user,
//				MultipartFile doc,
				String documento) {
			super();
			this.id = id;
			this.tipo_movimiento = tipo_movimiento;
			this.fecha_movimiento = fecha_movimiento;
			this.descripcion = descripcion;
	        this.id_sucursal = id_sucursal;
//	        this.departamentos = departamentos;
//	        this.empleado = empleado;
//	        this.user = user;
//			this.id_sucursal = id_sucursal;

			this.id_departamento = id_departamento;
			this.empleado_id = empleado_id;
			this.user_id = user_id;
//			this.doc = doc;
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

//		public Long getId_sucursal() {
//			return id_sucursal;
//		}
//
//		public void setId_sucursal(Long id_sucursal) {
//			this.id_sucursal = id_sucursal;
//		}

//		public Long getId_departamento() {
//			return id_departamento;
//		}
//
//		public void setId_departamento(Long id_departamento) {
//			this.id_departamento = id_departamento;
//		}

//		public Long getEmpleado_id() {
//			return empleado_id;
//		}
//
//		public void setEmpleado_id(Long empleado_id) {
//			this.empleado_id = empleado_id;
//		}

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


		public String getId_sucursal() {
			return id_sucursal;
		}


		public void setId_sucursal(String id_sucursal) {
			this.id_sucursal = id_sucursal;
		}


		public String getId_departamento() {
			return id_departamento;
		}


		public void setId_departamento(String id_departamento) {
			this.id_departamento = id_departamento;
		}


		public String getEmpleado_id() {
			return empleado_id;
		}


		public void setEmpleado_id(String empleado_id) {
			this.empleado_id = empleado_id;
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
