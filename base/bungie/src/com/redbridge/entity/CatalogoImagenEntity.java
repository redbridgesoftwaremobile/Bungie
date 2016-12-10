package com.redbridge.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;


/**
 * The persistent class for the catalogo_imagen database table.
 * 
 */
@Entity
@Table(name="catalogo_imagen")
@NamedQuery(name = "CatalogoImagen.findCatalogoImagenByID", query = "SELECT catalogoImagen FROM CatalogoImagenEntity as catalogoImagen WHERE catalogoImagen.id = ?")


public class CatalogoImagenEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Lob
	@Column(name="icono_back")
	private byte[] iconoBack;

	@Lob
	@Column(name="icono_front")
	private byte[] iconoFront;

	@Lob
	@Column(name="icono_left")
	private byte[] iconoLeft;

	@Lob
	@Column(name="icono_right")
	private byte[] iconoRight;

	@Lob
	@Column(name="imagen_back")
	private byte[] imagenBack;

	@Lob
	@Column(name="imagen_front")
	private byte[] imagenFront;

	@Lob
	@Column(name="imagen_left")
	private byte[] imagenLeft;

	@Lob
	@Column(name="imagen_right")
	private byte[] imagenRight;

	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getIconoBack() {
		return this.iconoBack;
	}

	public void setIconoBack(byte[] iconoBack) {
		this.iconoBack = iconoBack;
	}

	public byte[] getIconoFront() {
		return this.iconoFront;
	}

	public void setIconoFront(byte[] iconoFront) {
		this.iconoFront = iconoFront;
	}

	public byte[] getIconoLeft() {
		return this.iconoLeft;
	}

	public void setIconoLeft(byte[] iconoLeft) {
		this.iconoLeft = iconoLeft;
	}

	public byte[] getIconoRight() {
		return this.iconoRight;
	}

	public void setIconoRight(byte[] iconoRight) {
		this.iconoRight = iconoRight;
	}

	public byte[] getImagenBack() {
		return this.imagenBack;
	}

	public void setImagenBack(byte[] imagenBack) {
		this.imagenBack = imagenBack;
	}

	public byte[] getImagenFront() {
		return this.imagenFront;
	}

	public void setImagenFront(byte[] imagenFront) {
		this.imagenFront = imagenFront;
	}

	public byte[] getImagenLeft() {
		return this.imagenLeft;
	}

	public void setImagenLeft(byte[] imagenLeft) {
		this.imagenLeft = imagenLeft;
	}

	public byte[] getImagenRight() {
		return this.imagenRight;
	}

	public void setImagenRight(byte[] imagenRight) {
		this.imagenRight = imagenRight;
	}

}
