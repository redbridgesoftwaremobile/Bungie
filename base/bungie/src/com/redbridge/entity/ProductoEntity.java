package com.redbridge.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
//@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
@NamedQuery(name = "Producto.findProductoByProductoID", query = "SELECT producto  FROM ProductoEntity  as producto WHERE producto.id = ?")

public class ProductoEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String capacidad;

	private String carrier;

	private String codigo;

	private String color;

	private String descripcion;

	@Column(name="display_size")
	private String displaySize;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	
	
	@Lob
	@Column(name="icono_back")
	private byte[] iconoBack;

	@Lob
	@Column(name="icono_front")
	private byte[] iconoFront;

	@Lob
	@Column(name="icono_left")
	private byte[] iconoLeft;

	@Lob
	@Column(name="icono_right")
	private byte[] iconoRight;

	@Lob
	@Column(name="imagen_back")
	private byte[] imagenBack;

	@Lob
	@Column(name="imagen_front")
	private byte[] imagenFront;

	@Lob
	@Column(name="imagen_left")
	private byte[] imagenLeft;

	@Lob
	@Column(name="imagen_right")
	private byte[] imagenRight;

	private String marca;

	private String nombre;

	@Column(name="nota_tecnica")
	private String notaTecnica;

	@Column(name="sistema_operativo")
	private String sistemaOperativo;

	private String tipo;

	private String usuario;
	
	private BigDecimal precio;
	
	public ProductoEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getCarrier() {
		return this.carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDisplaySize() {
		return this.displaySize;
	}

	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public byte[] getIconoBack() {
		return iconoBack;
	}

	public void setIconoBack(byte[] iconoBack) {
		this.iconoBack = iconoBack;
	}

	public byte[] getIconoFront() {
		return iconoFront;
	}

	public void setIconoFront(byte[] iconoFront) {
		this.iconoFront = iconoFront;
	}

	public byte[] getIconoLeft() {
		return iconoLeft;
	}

	public void setIconoLeft(byte[] iconoLeft) {
		this.iconoLeft = iconoLeft;
	}

	public byte[] getIconoRight() {
		return iconoRight;
	}

	public void setIconoRight(byte[] iconoRight) {
		this.iconoRight = iconoRight;
	}

	public byte[] getImagenBack() {
		return imagenBack;
	}

	public void setImagenBack(byte[] imagenBack) {
		this.imagenBack = imagenBack;
	}

	public byte[] getImagenFront() {
		return imagenFront;
	}

	public void setImagenFront(byte[] imagenFront) {
		this.imagenFront = imagenFront;
	}

	public byte[] getImagenLeft() {
		return imagenLeft;
	}

	public void setImagenLeft(byte[] imagenLeft) {
		this.imagenLeft = imagenLeft;
	}

	public byte[] getImagenRight() {
		return imagenRight;
	}

	public void setImagenRight(byte[] imagenRight) {
		this.imagenRight = imagenRight;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNotaTecnica() {
		return this.notaTecnica;
	}

	public void setNotaTecnica(String notaTecnica) {
		this.notaTecnica = notaTecnica;
	}

	public String getSistemaOperativo() {
		return this.sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	

}
