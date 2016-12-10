package com.redbridge.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQuery;
//import org.hibernate.validator.constraints.Length;
//import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name="usuario_perfil")

public class UsuarioEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//@NotBlank(message = "Nombre no puede estar vacio")
	//@Size(min = 2, message = "Nombre es muy corto")
	private String firstName;

	//@NotBlank(message = "Apellido Paterno no puede estar vacio")
	//@Length(min = 2, max = 50, message = "Apellido Paterno debe tener de 2 a 50 Caracteres size")
	private String lastName;

	private String middleName;

	//@NotBlank(message = "Cuenta de Usuario no puede estar vacio")
	//@Pattern(regexp = "^[a-zA-Z]{2}-\\d+$", message = "Invalid Account Number Number. First two letter should be Alphabets and then one hyphen and then any digits. For example AA-333, BB-44")
	private String userAccountNumber;

	//@Pattern(regexp = "[0-9]{2}-[0-9]{8}", message = "Formato Invalido Numero Celular")
	private String SSN;

	//@NotBlank(message = "Dirección 1 no puede estar vacio")
	private String address1;

	private String address2;

	//@NotBlank(message = "Ciudad no puede estar vacio")
	private String city;

	//@NotBlank(message = "Estado no puede estar vacio")
	//@Length(min = 2, max = 2, message = "State should be 2   Characters size")
	private String State;

	//@NotBlank(message = "Codigo Postal no puede estar vacio")
	private String zipCode;

	//@NotBlank(message = "Email no puede estar vacio")
	//@org.hibernate.validator.constraints.Email(message = "Invalid Email Format")
	private String email;

	//@NotBlank(message = "Usuario no puede estar vacio")
	private String userLoginID;

	//@NotBlank(message = "Password no puede estar vacio")
	private String password;

	//@Transient
	private String confirmPassword;

	private Integer system;

	//@NotBlank(message = "Tema no puede estar vacio")
	private String theme;

	//@Column(name = "userPhoto")
	//@Lob
	private byte[] userPhoto;

	//@Temporal(TemporalType.DATE)
	//@Past(message = "Date of birth should be past date")
	private Date DOB;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUserAccountNumber() {
		return userAccountNumber;
	}

	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserLoginID() {
		return userLoginID;
	}

	public void setUserLoginID(String userLoginID) {
		this.userLoginID = userLoginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getSystem() {
		return system;
	}

	public void setSystem(Integer system) {
		this.system = system;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public byte[] getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
