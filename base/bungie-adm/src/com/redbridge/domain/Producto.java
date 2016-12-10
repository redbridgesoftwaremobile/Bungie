package com.redbridge.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;



@Entity
@Table(name = "producto", catalog = "tiendavirtual") 
@NamedQuery(name = "Producto.findProductoByID", query = "SELECT producto  FROM Producto  as producto WHERE producto.id = ?")
public class Producto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message = "Codigo no puede estar vacio")
	@Pattern(regexp = "^[a-zA-Z]{2}-\\d+$", message = "Codigo Invalido. Primeras dos letras deben ser del Alfabeto,un guion y cualquier Digito ,ejemplo: AA-333, BB-44")
	private String codigo;

	@NotBlank(message = "Nombre no puede estar vacio")
	@Size(min = 2, message = "Nombre es muy corto")
	private String nombre;

	@NotBlank(message = "Descripcion no puede estar vacio")
	@Length(min = 5, max = 200, message = "Descripcion debe tener minimo 5 Caracteres")
	private String descripcion;
	
	@NotBlank(message = "Nota Tecnica no puede estar vacio")
	@Length(min = 50, max = 450, message = "Nota Tecnica debe tener minimo 50 y maximo 450 Caracteres")
	private String nota_tecnica;
	
	@NotBlank(message = "Capacidad no puede estar vacio")
	private String capacidad;
    
	@NotBlank(message = "Tipo no puede estar vacio")
    private String tipo;
	@NotBlank(message = "Display no puede estar vacio")
    private String display_size;
	@NotBlank(message = "Marca no puede estar vacio")
    private String marca;
	@NotBlank(message = "Color no puede estar vacio")
    private String color;
	@NotBlank(message = "Sistema Operativo no puede estar vacio")
    private String sistema_operativo;
	@NotBlank(message = "Carrier no puede estar vacio")
    private String carrier;
   
	
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


	@Temporal(TemporalType.DATE)
	private Date fecha_alta;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_baja;
	
	@Temporal(TemporalType.DATE)
	private Date fecha_modificacion;
	
	private String usuario;
	
	private Integer system;
	
	@Column(precision=10, scale=2)
	private BigDecimal precio;
	

	
	
	

	public long getId() {
		return id;
	}






	public void setId(long id) {
		this.id = id;
	}






	public String getNombre() {
		return nombre;
	}






	public void setNombre(String nombre) {
		this.nombre = nombre;
	}






	public String getNota_tecnica() {
		return nota_tecnica;
	}






	public void setNota_tecnica(String nota_tecnica) {
		this.nota_tecnica = nota_tecnica;
	}






	public String getTipo() {
		return tipo;
	}






	public void setTipo(String tipo) {
		this.tipo = tipo;
	}






	public String getMarca() {
		return marca;
	}






	public void setMarca(String marca) {
		this.marca = marca;
	}






	public String getSistema_operativo() {
		return sistema_operativo;
	}






	public void setSistema_operativo(String sistema_operativo) {
		this.sistema_operativo = sistema_operativo;
	}






	public String getUsuario() {
		return usuario;
	}






	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	public String getCodigo() {
		return codigo;
	}






	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}






	public String getDescripcion() {
		return descripcion;
	}






	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}






	public String getCapacidad() {
		return capacidad;
	}






	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}






	public String getDisplay_size() {
		return display_size;
	}






	public void setDisplay_size(String display_size) {
		this.display_size = display_size;
	}






	public String getColor() {
		return color;
	}






	public void setColor(String color) {
		this.color = color;
	}






	public String getCarrier() {
		return carrier;
	}






	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}



	public Date getFecha_alta() {
		return fecha_alta;
	}






	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}






	public Date getFecha_baja() {
		return fecha_baja;
	}






	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}






	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}






	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
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






	public Integer getSystem() {
		return system;
	}






	public void setSystem(Integer system) {
		this.system = system;
	}






	public BigDecimal getPrecio() {
		return precio;
	}






	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	
	
}
