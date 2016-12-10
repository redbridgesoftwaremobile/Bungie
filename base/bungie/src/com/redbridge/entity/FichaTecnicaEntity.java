package com.redbridge.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ficha_tecnica_producto database table.
 * 
 */
@Entity
@Table(name="ficha_tecnica_producto")
//@NamedQuery(name="FichaTecnicaProducto.findAll", query="SELECT f FROM FichaTecnicaProducto f")
public class FichaTecnicaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	private String descripcion;

	
	public FichaTecnicaEntity() {
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

}
