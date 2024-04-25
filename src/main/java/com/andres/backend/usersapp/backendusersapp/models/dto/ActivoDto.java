package com.andres.backend.usersapp.backendusersapp.models.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class ActivoDto {
//listar los campos de la tabla activos para generar setter y getter

	private Long activo_id;
    private String nombre;
    //private boolean admin;
    private String descripcion;
    private Long fabricante_id;
    private String modelo;
    private String no_serie;
    private String clasificacion;
    private Long grupoactivo_id;
    private Long proveedor_id;
    private String factura;
    private Date fecha_compra;
    private BigDecimal importe;
    private Date fecha_ingreso;
    private String estatus;
    private String clave_busqueda;
    private MultipartFile imagen; // Columna para almacenar la imagen en formato de bytes
    private String foto;
    private MultipartFile doc; // Columna para almacenar la imagen en formato de bytes
    private String documento;
    private String Proveedor;



	public ActivoDto(Long activo_id, String nombre, String descripcion, Long fabricante_id, String modelo,
			String no_serie, String tipo, Long grupoactivo_id, Long proveedor_id, String factura,
			Date fecha_compra, BigDecimal importe, Date fecha_ingreso, String estatus, String clave_busqueda,
			MultipartFile imagen, String foto, String nombreProveedor, String documento) {
		super();
		this.activo_id = activo_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fabricante_id = fabricante_id;
		this.modelo = modelo;
		this.no_serie = no_serie;
		this.clasificacion = clasificacion;
		this.grupoactivo_id = grupoactivo_id;
		this.proveedor_id = proveedor_id;
		this.factura = factura;
		this.fecha_compra = fecha_compra;
		this.importe = importe;
		this.fecha_ingreso = fecha_ingreso;
		this.estatus = estatus;
		this.clave_busqueda = clave_busqueda;
		this.imagen = imagen;
		this.foto = foto;
		this.documento = documento;

		this.Proveedor = nombreProveedor;
	}

	public Long getActivo_id() {
		return activo_id;
	}
	public void setActivo_id(Long activo_id) {
		this.activo_id = activo_id;
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

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNo_serie() {
		return no_serie;
	}
	public void setNo_serie(String no_serie) {
		this.no_serie = no_serie;
	}


	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
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

	public MultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}

	public Long getFabricante_id() {
		return fabricante_id;
	}

	public void setFabricante_id(Long fabricante_id) {
		this.fabricante_id = fabricante_id;
	}

	public Long getGrupoactivo_id() {
		return grupoactivo_id;
	}

	public void setGrupoactivo_id(Long grupoactivo_id) {
		this.grupoactivo_id = grupoactivo_id;
	}

	public Long getProveedor_id() {
		return proveedor_id;
	}

	public void setProveedor_id(Long proveedor_id) {
		this.proveedor_id = proveedor_id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	public MultipartFile getDoc() {
		return doc;
	}

	public void setDoc(MultipartFile doc) {
		this.doc = doc;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getProveedor() {
		return Proveedor;
	}

	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}



}
