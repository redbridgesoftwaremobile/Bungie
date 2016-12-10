package com.redbridge.entity;


import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
/**
 * The persistent class for the precio_producto database table.
 * 
 */
@Entity
@Table(name="precio_producto")
//@NamedQuery(name="PrecioProducto.findAll", query="SELECT p FROM PrecioProducto p")

public class PrecioProductoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	@Column(name="id_capacidad")
	private int idCapacidad;

	@Column(name="id_color")
	private int idColor;

	@Column(name="id_producto")
	private int idProducto;

	private BigDecimal precio;

	public PrecioProductoEntity() {
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
