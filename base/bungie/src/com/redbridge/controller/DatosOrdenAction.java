package com.redbridge.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.persistence.Column;

import org.apache.log4j.Logger;
//import org.apache.struts2.edit.model.State;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.redbridge.dto.Pagination;
import com.redbridge.dto.ServicioMensajeriaSession;
import com.redbridge.dto.ShoppingCartSession;
import com.redbridge.dto.UserSession;
import com.redbridge.entity.CapacidadEntity;
import com.redbridge.entity.ClienteEntity;
import com.redbridge.entity.ColorEntity;
import com.redbridge.entity.DisplaySizeEntity;
import com.redbridge.entity.DomicilioEntity;
import com.redbridge.entity.MarcaEntity;
import com.redbridge.entity.ProductoEntity;
import com.redbridge.entity.TarjetaClienteEntity;
import com.redbridge.service.CRUDService;
import com.redbridge.webservice.WebClientBungie;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;



public class DatosOrdenAction extends ActionSupport implements Preparable, SessionAware, RequestAware	{

    private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(DatosOrdenAction.class);
			
	
	//Session,Request Objects
	private Map<String, Object> sesion;
	private Map<String, Object> req;
	//Session Objects Injected by Spring Context
	private ShoppingCartSession shoppingCartSession;
	private UserSession userSession;
	private TarjetaClienteEntity tarjetaBean;
	private DomicilioEntity      domicilioBean;
	private ServicioMensajeriaSession dhlBean;
	//procesed fields for invoice
	
	
	
	//CRUD Service injected by spring context; This is cool !!
	@Autowired
	private CRUDService crudService;
	
	
	
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.	
	@Override
	public void prepare() throws Exception {	
		userSession          =(UserSession)sesion.get("userSession");
		shoppingCartSession  =(ShoppingCartSession)sesion.get("shoppingCartSession");	
		dhlBean              =(ServicioMensajeriaSession)sesion.get("dhlBean");
	}
	
	
	@Override
	public String execute() throws Exception{
		//LOGIC TO APPLY BANK PAYMENT WITH WS
		// http://localhost:8090/externalservices/banorte/101
		// return "Tarjeta Aprobada"
		//LOGIC TO PRINT TICKET
		
        //WebClientBungie webclient = new WebClientBungie();
		//System.out.println("WebService BANORTE:"+webclient.getRestBanorte("101"));
		
		userSession          =new UserSession();
		shoppingCartSession  =new ShoppingCartSession();	
		dhlBean              =new ServicioMensajeriaSession();
		
		sesion.put("userSession", userSession);
		sesion.put("shoppingCartSession", shoppingCartSession);
		sesion.put("dhlBean", dhlBean);
		
		return SUCCESS;		
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

	public TarjetaClienteEntity getTarjeta() {
		return tarjetaBean;
	}

	public void setTarjeta(TarjetaClienteEntity tarjetaBean) {
		this.tarjetaBean = tarjetaBean;
	}

	public DomicilioEntity getDomicilio() {
		return domicilioBean;
	}

	public void setDomicilio(DomicilioEntity domicilioBean) {
		this.domicilioBean = domicilioBean;
	}

	public TarjetaClienteEntity getTarjetaBean() {
		return tarjetaBean;
	}
	
	public void setTarjetaBean(TarjetaClienteEntity tarjetaBean) {
		this.tarjetaBean = tarjetaBean;
	}
	
	public DomicilioEntity getDomicilioBean() {
		return domicilioBean;
	}
	
	public void setDomicilioBean(DomicilioEntity domicilioBean) {
		this.domicilioBean = domicilioBean;
	}

	

	public ServicioMensajeriaSession getDhlBean() {
		return dhlBean;
	}

	public void setDhlBean(ServicioMensajeriaSession dhlBean) {
		this.dhlBean = dhlBean;
	}

	


}
