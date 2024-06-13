package com.andres.backend.usersapp.backendusersapp.models.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="activo")
public class Activo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activo_id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @NotBlank
    private String modelo;

    @NotBlank
    private String no_serie;

//    @NotBlank
//    private String tipo;
    
    @NotBlank
    private String clasificacion;

    @NotBlank
    private String factura;

    @NotBlank
    private String estatus;

    @NotBlank
    private String clave_busqueda;

    @NotNull(message = "El importe no puede ser nulo")
    private BigDecimal importe;

    @NotNull
    private Date fecha_compra;

    @NotNull
    private Date fecha_ingreso;

    private byte[] imagen; // Columna para almacenar la imagen en formato de bytes

    private String foto;
    
    private byte[] doc; // Columna para almacenar la imagen en formato de bytes

    private String documento;
    
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    
	@JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "fabricante_id")  // Nombre de la columna en la tabla de Activos que referencia
    private Fabricante fabricante;
	
	@JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "grupoactivo_id")  // Nombre de la columna en la tabla de Activos que referencia
    private Grupoactivo grupoactivo;

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
//	public String getTipo() {
//		return tipo;
//	}
//	public void setTipo(String tipo) {
//		this.tipo = tipo;
//	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
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
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	public Date getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

//	public Long getGrupoactivo_id() {
//		return grupoactivo_id;
//	}
//	public void setGrupoactivo_id(Long grupoactivo_id) {
//		this.grupoactivo_id = grupoactivo_id;
//	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	public byte[] getDoc() {
		return doc;
	}
	public void setDoc(byte[] doc) {
		this.doc = doc;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public Grupoactivo getGrupoactivo() {
		return grupoactivo;
	}
	public void setGrupoactivo(Grupoactivo grupoactivo) {
		this.grupoactivo = grupoactivo;
	}

}
