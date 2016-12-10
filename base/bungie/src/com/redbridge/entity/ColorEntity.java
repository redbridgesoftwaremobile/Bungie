package com.redbridge.entity;


import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the color_producto database table.
 * 
 */
@Entity
@Table(name="color_producto")
//@NamedQuery(name="ColorProducto.findAll", query="SELECT c FROM ColorProducto c")

public class ColorEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
