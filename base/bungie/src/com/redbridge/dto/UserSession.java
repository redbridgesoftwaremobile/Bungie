package com.redbridge.dto;

import java.io.Serializable;

import com.redbridge.entity.DomicilioEntity;
import com.redbridge.entity.TarjetaClienteEntity;

public class UserSession implements Serializable {
	
	private String nombre;
	private String apellidoPaterno;
	
	private DomicilioEntity domicilio;
	private TarjetaClienteEntity tarjeta;
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public DomicilioEntity getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioEntity domicilio) {
		this.domicilio = domicilio;
	}
	public TarjetaClienteEntity getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(TarjetaClienteEntity tarjeta) {
		this.tarjeta = tarjeta;
	}
	
}
