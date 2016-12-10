package com.redbridge.entity;


import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the domicilio database table.
 * 
 */
@Entity
@Table(name="domicilio")
//@NamedQuery(name="Domicilio.findAll", query="SELECT d FROM Domicilio d")
@NamedQuery(name = "Domicilio.findDomicilioByID", query = "SELECT domicilio  FROM DomicilioEntity  as domicilio WHERE domicilio.id = ?")

public class DomicilioEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	
	private String calle;

	private String ciudad;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private String colonia;

	private String delegacion;

	private String estado;

	

	@Column(name="numero_ext")
	private String numeroExt;

	@Column(name="numero_int")
	private String numeroInt;

	private String pais;

	public DomicilioEntity() {
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getColonia() {
		return this.colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getDelegacion() {
		return this.delegacion;
	}

	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroExt() {
		return this.numeroExt;
	}

	public void setNumeroExt(String numeroExt) {
		this.numeroExt = numeroExt;
	}

	public String getNumeroInt() {
		return this.numeroInt;
	}

	public void setNumeroInt(String numeroInt) {
		this.numeroInt = numeroInt;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
