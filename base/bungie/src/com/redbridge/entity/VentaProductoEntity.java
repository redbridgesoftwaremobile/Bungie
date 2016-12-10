package com.redbridge.entity;


import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the venta_producto database table.
 * 
 */
@Entity
@Table(name="venta_producto")
//@NamedQuery(name="VentaProducto.findAll", query="SELECT v FROM VentaProducto v")

public class VentaProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	@Column(name="costo_envio")
	private BigDecimal costoEnvio;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	@Column(name="id_capacidad")
	private int idCapacidad;

	@Column(name="id_cliente")
	private int idCliente;
	
	private int cantidad;

	@Column(name="id_color")
	private int idColor;

	@Column(name="id_producto")
	private int idProducto;

	private BigDecimal precio;

	public VentaProductoEntity() {
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCostoEnvio() {
		return this.costoEnvio;
	}

	public void setCostoEnvio(BigDecimal costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCapacidad() {
		return this.idCapacidad;
	}

	public void setIdCapacidad(int idCapacidad) {
		this.idCapacidad = idCapacidad;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdColor() {
		return this.idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

}
