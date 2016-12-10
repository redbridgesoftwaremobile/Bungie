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



public class IndexAction extends ActionSupport implements Preparable, SessionAware, RequestAware	{

    private static final long serialVersionUID = 1L;
	
	//Logger configured using log4j
	private static final Logger logger = Logger.getLogger(IndexAction.class);
	//FormBean attributes 
	private String page_size;
	private String page_number;
	private String selectMarca;
	private String selectDisplaySize;
	private String selectCapacidad;
	private String selectColor;
	private String nombreProducto;
	
	
	//List of catalogs; Setter and Getter are below
	private List<MarcaEntity> marcas;
	private List<CapacidadEntity> capacidades;
	private List<DisplaySizeEntity> displaySizes;
	private List<ColorEntity> colores;
	private List<ProductoEntity> productos;
	//Entity object to be added; Setter and Getter are below
	private MarcaEntity marca;
	private CapacidadEntity capacidad;
	private DisplaySizeEntity displaySize;
	private ColorEntity colorEntity;
	private ClienteEntity usuario;
	private ProductoEntity productoEntity;
	//Session,Request Objects
	private Map<String, Object> sesion;
	private Map<String, Object> req;
	//Session Objects Injected by Spring Context
	private ShoppingCartSession shoppingCartSession;
	private UserSession userSession;	
	//CRUD Service injected by spring context; This is cool !!
	@Autowired
	private CRUDService crudService;
	
	//Initializing Pagination with page size 10, and current page 1 
    private Pagination pagination = null;
	
	
	//This method will be called before any of Action method is invoked;
	//So some pre-processing if required.	
	@Override
	public void prepare() throws Exception {
		
		marca          = null;
		capacidad      = null;
		displaySize    = null;
		colorEntity    = null;
		productoEntity = null;
		
		
		Object o = sesion.get("shoppingCartSession");
		if(o==null){
			shoppingCartSession = new ShoppingCartSession();
			sesion.put("shoppingCartSession", shoppingCartSession);
		}		
		userSession = new UserSession();
		userSession.setNombre("HELI");
		userSession.setApellidoPaterno("VERGARA");
		
		productos    = crudService.getAll(ProductoEntity.class);
		//Getting Total producto records count from database..
		pagination = new Pagination(6, 1);
        pagination.setProperties(productos.size());
        sesion.put("pagination", pagination);
		sesion.put("productosSession", productos.subList(pagination.getStart(), pagination.getEnd()));
		sesion.put("userSession", userSession);
		
		
		
				
	}
	
	@Override
	public String execute() throws Exception{
		
		pagina();		
		return SUCCESS;
		
	}
	
	public String filtra() throws Exception {		
		productos    = crudService.queryByProducto(ProductoEntity.class,
				this.getNombreProducto(),this.getSelectMarca(),this.getSelectColor(),this.getSelectCapacidad(),this.getSelectDisplaySize());
		pagina();
		
		return SUCCESS;
	}
	
	public void pagina(){
		
		
		marcas       = crudService.getAll(MarcaEntity.class);
		capacidades  = crudService.getAll(CapacidadEntity.class);
		displaySizes = crudService.getAll(DisplaySizeEntity.class);
		colores      = crudService.getAll(ColorEntity.class);
		//PAGINACION DE REGISTROS	
		pagination = (Pagination) sesion.get("pagination");
		pagination.setPage_size(getPage_size()!=null?Integer.parseInt(getPage_size()):6);
		pagination.setPage_number(getPage_number()!=null?Integer.parseInt(getPage_number()):1);
		pagination.setProperties(productos.size());	
		sesion.put("productosSession", productos.subList(pagination.getStart(), pagination.getEnd()));
	
	}
	

	public List<MarcaEntity> getMarcas() {
		return marcas;
	}

	public List<CapacidadEntity> getCapacidades() {
		return capacidades;
	}

	public List<DisplaySizeEntity> getDisplaySizes() {
		return displaySizes;
	}

	public List<ColorEntity> getColores() {
		return colores;
	}
	
	public List<ProductoEntity> getProductos() {
		return productos;
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

	
	
	
	

		
	

}
