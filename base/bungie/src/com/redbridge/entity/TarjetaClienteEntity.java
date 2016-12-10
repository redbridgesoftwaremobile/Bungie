package com.redbridge.entity;


import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the tarjeta_cliente database table.
 * 
 */
@Entity
@Table(name="tarjeta_cliente")
//@NamedQuery(name="TarjetaCliente.findAll", query="SELECT t FROM TarjetaCliente t")
@NamedQuery(name = "TarjetaCliente.findTarjetaClienteByID", query = "SELECT tarjeta  FROM TarjetaClienteEntity  as tarjeta WHERE tarjeta.id = ?")


public class TarjetaClienteEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;

	@Column(name="apellido_materno")
	private String apellidoMaterno;

	@Column(name="apellido_paterno")
	private String apellidoPaterno;

	@Column(name="codigo_seguridad")
	private String codigoSeguridad;

	@Column(name="month_vencimiento")
	private String monthVencimiento;

	private String nombre;

	@Column(name="numero_tarjeta")
	private String numeroTarjeta;

	@Column(name="tipo_tarjeta")
	private String tipoTarjeta;

	@Column(name="year_vencimiento")
	private String yearVencimiento;

	public TarjetaClienteEntity() {
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getCodigoSeguridad() {
		return this.codigoSeguridad;
	}

	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMonthVencimiento() {
		return this.monthVencimiento;
	}

	public void setMonthVencimiento(String monthVencimiento) {
		this.monthVencimiento = monthVencimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getTipoTarjeta() {
		return this.tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getYearVencimiento() {
		return this.yearVencimiento;
	}

	public void setYearVencimiento(String yearVencimiento) {
		this.yearVencimiento = yearVencimiento;
	}
}
