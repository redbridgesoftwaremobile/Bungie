package com.redbridge.controller;


import java.math.BigDecimal;
import java.math.RoundingMode;
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



public class DatosTarjetaAction extends ActionSupport implements Preparable, SessionAware, RequestAware	{

    private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(DatosTarjetaAction.class);
	private static final String IVA_MEXICO = "16";
	
	//FormBean attributes LAST PAGE	
	private String keyProducto;
	private String index;
	private String page_size;
	private String page_number;
	private String selectMarca;
	private String selectDisplaySize;
	private String selectCapacidad;
	private String selectColor;
	private String nombreProducto;	
	
	private TarjetaClienteEntity tarjetaBean;
	private DomicilioEntity      domicilioBean;
	private ServicioMensajeriaSession dhlBean;
	private String [] visa = {"visa"};
	private String [] mastercard = {"mastercard"};
	private List<Month> meses ;
	private List<Year>  years ;
	
	
	
	//List of catalogs; Setter and Getter are below

	//Entity object to be added; Setter and Getter are below
	
	private ProductoEntity producto;
	//Session,Request Objects
	private Map<String, Object> sesion;
	private Map<String, Object> req;
	//Session Objects Injected by Spring Context
	private ShoppingCartSession shoppingCartSession;
	private UserSession userSession;
	private String terminacionTarjeta;
	private String tipoTarjeta;
	private String costoEnvio;
	private String costoArticulos;
	private String costoIva;
	private String costoTotalplusIva;
	private String numeroArticulos;
	
	
	
	
	//CRUD Service injected by spring context; This is cool !!
	@Autowired
	private CRUDService crudService;
	
	
	
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.	
	@Override
	public void prepare() throws Exception {	
		userSession = (UserSession)sesion.get("userSession");
		shoppingCartSession = (ShoppingCartSession)sesion.get("shoppingCartSession");
		
	}
	
	@Override
	public String input() throws Exception {	
		tarjetaBean   = (tarjetaBean!=null)?tarjetaBean:new TarjetaClienteEntity();
		domicilioBean = (domicilioBean!=null)?domicilioBean:new DomicilioEntity();			
		return INPUT;
	}
		
		
	@Override
	public String execute() throws Exception{		
		//crudService.Save(tarjetaBean);
		//crudService.Save(domicilioBean);
		userSession.setDomicilio(domicilioBean);
		//LLama WEBService DHL
		callWSDHL(shoppingCartSession,domicilioBean,tarjetaBean);
		//LLama WEBService DHL
		//http://localhost:8090/externalservices/dhl/101
		//return 236.80
		//TEST FROM LINUX: curl -X GET -i http://localhost:8090/externalservices/dhl/101
		//WebClientBungie webclient = new WebClientBungie();
		//System.out.println("WebService DHL:"+webclient.getRestDHL("101"));
		
		
		
		userSession.setTarjeta(tarjetaBean);
		terminacionTarjeta = get4DigitosTarjeta();		
		tipoTarjeta        = get2TiposTarjeta();
		costoEnvio         = dhlBean.getPrecio();
		costoArticulos     = shoppingCartSession.getSubtotal();
		costoTotalplusIva  = calculaTotalplusIVA(costoArticulos,costoEnvio,IVA_MEXICO);
		numeroArticulos    = String.valueOf(shoppingCartSession.getCantidad());
		return SUCCESS;		
	}
	
	
	public void callWSDHL(ShoppingCartSession carritoCompras, DomicilioEntity domicilio,TarjetaClienteEntity tarjeta){		
		//LOGIC DHL WEBSERVICE		
		dhlBean = new ServicioMensajeriaSession();
		dhlBean.setPrecio("320.00");
		sesion.put("dhlBean", dhlBean);		
	}
	
			
	@Override
	public void validate() {
		
		
		
		// TODO Auto-generated method stub
		if(tarjetaBean.getNombre().equalsIgnoreCase(""))
			addFieldError("tarjetaBean.nombre","Falta Nombre de Tarjeta");
		if(tarjetaBean.getApellidoPaterno().equalsIgnoreCase(""))
			addFieldError("tarjetaBean.apellidoPaterno","Falta Apellido de Tarjeta");
		if(tarjetaBean.getNumeroTarjeta().equalsIgnoreCase(""))
			addFieldError("tarjetaBean.numeroTarjeta","Falta Numero de Tarjeta");
		if(tarjetaBean.getCodigoSeguridad().equalsIgnoreCase(""))
			addFieldError("tarjetaBean.codigoSeguridad","Falta Codigo Seguridad de Tarjeta");
		if(tarjetaBean.getMonthVencimiento().equalsIgnoreCase(""))
			addFieldError("tarjetaBean.monthVencimiento","Falta Mes Vencimiento de Tarjeta");
		if(tarjetaBean.getYearVencimiento().equalsIgnoreCase(""))
			addFieldError("tarjetaBean.yearVencimiento","Falta Año Vencimiento de Tarjeta");
		if(domicilioBean.getCalle().equalsIgnoreCase(""))
			addFieldError("domicilioBean.calle","Falta Calle de Domicilio");
		if(domicilioBean.getNumeroExt().equalsIgnoreCase(""))
			addFieldError("domicilioBean.numeroExt","Falta Numero Ext De Domicilio");
		if(domicilioBean.getColonia().equalsIgnoreCase(""))
			addFieldError("domicilioBean.colonia","Falta Colonia de Domicilio");
		if(domicilioBean.getDelegacion().equalsIgnoreCase(""))
			addFieldError("domicilioBean.delegacion","Falta Delegacion de Delegacion");
		if(domicilioBean.getCiudad().equalsIgnoreCase(""))
			addFieldError("domicilioBean.ciudad","Falta Ciudad de Domicilio");
		if(domicilioBean.getEstado().equalsIgnoreCase(""))
			addFieldError("domicilioBean.estado","Falta Estado de Domicilio");
		if(domicilioBean.getCodigoPostal().equalsIgnoreCase(""))
			addFieldError("domicilioBean.codigoPostal","Falta Codigo Postal de Domicilio");
			
		
	}
	
	public String calculaTotalplusIVA(String costoArticulos,String costoEnvio,String ivaPais){
		
		BigDecimal costoArt = new BigDecimal(costoArticulos);
		BigDecimal costoEnv = new BigDecimal(costoEnvio);
		
		BigDecimal suma     = costoArt.add(costoEnv);
		
		BigDecimal iva      = (suma.multiply(new BigDecimal(ivaPais))).divide(new BigDecimal(100),2,RoundingMode.UP);
		
		BigDecimal total    = suma.add(iva);
		
		return  total.toString();
		
	}
	
    public String get4DigitosTarjeta(){
		
		String numero = tarjetaBean.getNumeroTarjeta();
		StringTokenizer st = new StringTokenizer(numero, "-");
		String token= "";
		
		for(int i=0;i<4;i++){
			token= st.nextToken();
		}
		return token;
	}
	
	public String get2TiposTarjeta(){
		String tipoTarjeta = "images/masterCard.jpg";
		
		if(tarjetaBean.getTipoTarjeta().equalsIgnoreCase("visa"))
			tipoTarjeta = "images/visa.jpg";		
		
		return tipoTarjeta;
	}
	
    class Month{
		
		private String mesAbbr;
		private String mesName;
		
		Month(String abr, String name){
			this.setMesmesAbbr(abr);
			this.setMesName(name);
		}
		
		public String getMesAbbr() {
			return mesAbbr;
		}
		public void setMesmesAbbr(String mesmesAbbr) {
			this.mesAbbr = mesmesAbbr;
		}
		public String getMesName() {
			return mesName;
		}
		public void setMesName(String mesName) {
			this.mesName = mesName;
		}
		
		
	}
	
	class Year{
		
		private String yearAbbr;
		private String yearName;
		
		Year(String abr, String name){
			this.setYearAbbr(abr);
			this.setYearName(name);
		}
		
		public String getYearAbbr() {
			return yearAbbr;
		}
		public void setYearAbbr(String yearAbbr) {
			this.yearAbbr = yearAbbr;
		}
		public String getYearName() {
			return yearName;
		}
		public void setYearName(String yearName) {
			this.yearName = yearName;
		}
		
		
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

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
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

	public String[] getVisa() {
		return visa;
	}

	public void setVisa(String[] visa) {
		this.visa = visa;
	}

	public String[] getMastercard() {
		return mastercard;
	}

	public void setMastercard(String[] mastercard) {
		this.mastercard = mastercard;
	}

	public List<Month> getMeses() {
		
		meses = new ArrayList<Month>();
		meses.add( new Month("ENE", "ENERO") );
		meses.add( new Month("FEB", "FEBRERO") );
		meses.add( new Month("MAR", "MARZO") );
		meses.add( new Month("ABR", "ABRIL") );
		meses.add( new Month("MAY", "MAYO") );
		meses.add( new Month("JUN", "JUNIO") );
		meses.add( new Month("JUL", "JULIO") );
		meses.add( new Month("AGO", "AGOSTO") );
		meses.add( new Month("SEP", "SEPTIEMBRE") );
		meses.add( new Month("OCT", "OCTUBRE") );
		meses.add( new Month("NOV", "NOVIEMBRE") );
		meses.add( new Month("DIC", "DICIEMBRE") );
		return meses;
	}
	
public List<Year> getYears() {
		
		years = new ArrayList<Year>();
		years.add( new Year("2015", "2015") );
		years.add( new Year("2016", "2016") );
		years.add( new Year("2017", "2017") );
		years.add( new Year("2018", "2018") );
		years.add( new Year("2019", "2019") );
		years.add( new Year("2020", "202") );
		years.add( new Year("2021", "2021") );
		years.add( new Year("2022", "2022") );
		years.add( new Year("2023", "2023") );
		years.add( new Year("2024", "2024") );
		years.add( new Year("2025", "2025") );
		return years;
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

	public String getTerminacionTarjeta() {
		return terminacionTarjeta;
	}

	public void setTerminacionTarjeta(String terminacionTarjeta) {
		this.terminacionTarjeta = terminacionTarjeta;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public String getCostoEnvio() {
		return costoEnvio;
	}

	public void setCostoEnvio(String costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

	public String getCostoArticulos() {
		return costoArticulos;
	}

	public void setCostoArticulos(String costoArticulos) {
		this.costoArticulos = costoArticulos;
	}

	public String getCostoIva() {
		return costoIva;
	}

	public void setCostoIva(String costoIva) {
		this.costoIva = costoIva;
	}

	public String getCostoTotalplusIva() {
		return costoTotalplusIva;
	}

	public void setCostoTotalplusIva(String costoTotalplusIva) {
		this.costoTotalplusIva = costoTotalplusIva;
	}

	public String getNumeroArticulos() {
		return numeroArticulos;
	}

	public void setNumeroArticulos(String numeroArticulos) {
		this.numeroArticulos = numeroArticulos;
	}

    
}
