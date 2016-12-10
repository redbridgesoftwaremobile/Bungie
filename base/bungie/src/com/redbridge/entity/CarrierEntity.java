package com.redbridge.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the carrier database table.
 * 
 */
@Entity
@Table(name="carrier")
//@NamedQuery(name="Carrier.findAll", query="SELECT c FROM Carrier c")

public class CarrierEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	@Column(name="nombre")
	private String nombre;

	

	public CarrierEntity() {
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
