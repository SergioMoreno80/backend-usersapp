package com.andres.backend.usersapp.backendusersapp.models.dto;

import java.util.Date;



public class MovimientoResponseDto {

//	 	private Long id;
//	    private String tipo_movimiento;
//	    private Date fecha_movimiento;
//	    private String descripcion;
//	    private String nombreSucursal;
//	    private String nombreDepartamento;
//	    private String nombreEmpleado;
//	    private String nombreUsuario;
//	    private String documento;
	    private String tipo_movimiento;
	    private Date fecha_movimiento;
	    private String descripcion;
	    private String documento;
	    private String nombreProveedor;
	    private String nombreSucursal;
	    private String nombreEmpleado;
	    private String nombreDepartamento;

	 // Constructor
//	    public MovimientoResponseDto(Long id, String tipo_movimiento, Date fecha_movimiento, String descripcion, String nombreSucursal, String nombreDepartamento, String nombreEmpleado) {
//	        this.id = id;
//	        this.tipo_movimiento = tipo_movimiento;
//	        this.fecha_movimiento = fecha_movimiento;
//	        this.descripcion = descripcion;
//	        this.nombreSucursal = nombreSucursal;
//	        this.nombreDepartamento = nombreDepartamento;
//	        this.nombreEmpleado = nombreEmpleado;
//	    }

	 // Constructor
	    public MovimientoResponseDto(String tipoMovimiento, Date fechaMovimiento, String descripcion,
	                                 String documento, String nombreProveedor, String nombreSucursal,
	                                 String nombreEmpleado, String nombreDepartamento) {
	        this.tipo_movimiento = tipoMovimiento;
	        this.fecha_movimiento = fechaMovimiento;
	        this.descripcion = descripcion;
	        this.documento = documento;
	        this.nombreProveedor = nombreProveedor;
	        this.nombreSucursal = nombreSucursal;
	        this.nombreEmpleado = nombreEmpleado;
	        this.nombreDepartamento = nombreDepartamento;
	    }



}

