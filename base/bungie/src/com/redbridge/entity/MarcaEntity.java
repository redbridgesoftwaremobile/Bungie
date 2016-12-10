package com.redbridge.entity;


import java.io.Serializable;

import javax.persistence.*;


 /* The persistent class for the marca database table.
 * 
 */
@Entity
@Table(name="marca")
//@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")

public class MarcaEntity implements Serializable{
	
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


