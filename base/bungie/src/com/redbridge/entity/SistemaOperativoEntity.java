package com.redbridge.entity;


import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the sistema_operativo database table.
 * 
 */
@Entity
@Table(name="sistema_operativo")
//@NamedQuery(name="SistemaOperativo.findAll", query="SELECT s FROM SistemaOperativo s")
public class SistemaOperativoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	@Column(name="nombre")
	private String nombre;

	@Column(name="descripcion")
	private String descripcion;

	public SistemaOperativoEntity() {
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
