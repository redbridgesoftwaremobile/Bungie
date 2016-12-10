package com.redbridge.controller;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbridge.dto.Pagination;
import com.redbridge.dto.ShoppingCartSession;
import com.redbridge.dto.UserSession;
import com.redbridge.entity.CapacidadEntity;
import com.redbridge.entity.ClienteEntity;
import com.redbridge.entity.ColorEntity;
import com.redbridge.entity.DisplaySizeEntity;
import com.redbridge.entity.MarcaEntity;
import com.redbridge.entity.ProductoEntity;
import com.redbridge.service.CRUDService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;



public class DetalleAction extends ActionSupport implements Preparable, SessionAware, RequestAware	{

    private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(DetalleAction.class);
	//FormBean attributes 	
	private String keyProducto;
	private String index;
	private String page_size;
	private String page_number;
	private String selectMarca;
	private String selectDisplaySize;
	private String selectCapacidad;
	private String selectColor;
	private String nombreProducto;
	//List of catalogs; Setter and Getter are below

	//Entity object to be added; Setter and Getter are below
	
	private ProductoEntity producto;
	//Session,Request Objects
	private Map<String, Object> sesion;
	private Map<String, Object> req;
	//Session Objects Injected by Spring Context
	//private ShoppingCartSession shoppingCartSession;
	private UserSession userSession;	
	//CRUD Service injected by spring context; This is cool !!
	@Autowired
	private CRUDService crudService;
	
	
	
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.	
	@Override
	public void prepare() throws Exception {		
								
	}
	
	@Override
	public String execute() throws Exception{	
		producto = crudService.GetUniqueEntityByNamedQuery("Producto.findProductoByProductoID", keyProducto);
		sesion.put("producto", producto);
		return SUCCESS;		
	}
		
	
	public String add2ShoppingCart() throws Exception{
		ShoppingCartSession shoppingCart = (ShoppingCartSession) sesion.get("shoppingCartSession");
		producto = crudService.GetUniqueEntityByNamedQuery("Producto.findProductoByProductoID", keyProducto);
		shoppingCart.addProducto(producto);
		
		return SUCCESS;		
	}
	
	public String delete2ShoppingCart() throws Exception{
		ShoppingCartSession shoppingCart = (ShoppingCartSession) sesion.get("shoppingCartSession");
		shoppingCart.deleteProducto(Integer.parseInt(index));		
		return SUCCESS;		
	}

	public ProductoEntity getProducto() {
		return producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

	public void setCrudService(CRUDService crudService) {
		this.crudService = crudService;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.sesion = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.req = arg0;
		
	}

	public String getKeyProducto() {
		return keyProducto;
	}

	public void setKeyProducto(String keyProducto) {
		this.keyProducto = keyProducto;
	}

	public String getPage_size() {
		return page_size;
	}

	public void setPage_size(String page_size) {
		this.page_size = page_size;
	}

	public String getPage_number() {
		return page_number;
	}

	public void setPage_number(String page_number) {
		this.page_number = page_number;
	}

	public String getSelectMarca() {
		return selectMarca;
	}

	public void setSelectMarca(String selectMarca) {
		this.selectMarca = selectMarca;
	}

	public String getSelectDisplaySize() {
		return selectDisplaySize;
	}

	public void setSelectDisplaySize(String selectDisplaySize) {
		this.selectDisplaySize = selectDisplaySize;
	}

	public String getSelectCapacidad() {
		return selectCapacidad;
	}

	public void setSelectCapacidad(String selectCapacidad) {
		this.selectCapacidad = selectCapacidad;
	}

	public String getSelectColor() {
		return selectColor;
	}

	public void setSelectColor(String selectColor) {
		this.selectColor = selectColor;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
	

}
