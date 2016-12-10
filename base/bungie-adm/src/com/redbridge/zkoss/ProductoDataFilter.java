package com.redbridge.zkoss;

public class ProductoDataFilter {

	private String codigo = "";
	private String nombre = "";
	private String marca = "";
	private String tipo = "";
	private String capacidad= "";
	private String color= "";

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo == null ? "" : codigo.trim();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre == null ? "" : nombre.trim();
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca == null ? "" : marca.trim();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo == null ? "" : tipo.trim();
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad == null ? "" : capacidad.trim();
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color == null ? "" : color.trim();
	}
 
}
