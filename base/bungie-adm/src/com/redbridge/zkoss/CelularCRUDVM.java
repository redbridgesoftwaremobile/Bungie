package com.redbridge.zkoss;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.image.Image;
import org.zkoss.util.media.Media;
import org.zkoss.web.theme.StandardTheme.ThemeOrigin;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Center;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.theme.Themes;

import com.redbridge.domain.Producto;
import com.redbridge.domain.UserProfile;
import com.redbridge.service.CRUDService;
import com.redbridge.utilities.MyLib;
import com.redbridge.domain.UserProfile;

public class CelularCRUDVM implements Serializable{

	private Center centerArea;

	@WireVariable
	private CRUDService CRUDService;

	
	
	private Producto selectedRecord;
	private String recordMode;
	private boolean makeAsReadOnly;
	private ProductoDataFilter dataFilter = new ProductoDataFilter();
	private AImage iconoFront;
	private AImage iconoBack;
	private AImage iconoLeft;
	private AImage iconoRight;
	private AImage imagenFront;
	private AImage imagenBack;
	private AImage imagenLeft;
	private AImage imagenRight;

	/*public AImage getMyImage() {
		return myImage;
	}

	public void setMyImage(AImage myImage) {
		this.myImage = myImage;
	}*/
	
	

	public AImage getIconoFront() {
		return iconoFront;
	}

	public void setIconoFront(AImage iconoFront) {
		this.iconoFront = iconoFront;
	}

	public AImage getIconoBack() {
		return iconoBack;
	}

	public void setIconoBack(AImage iconoBack) {
		this.iconoBack = iconoBack;
	}

	public AImage getIconoLeft() {
		return iconoLeft;
	}

	public void setIconoLeft(AImage iconoLeft) {
		this.iconoLeft = iconoLeft;
	}

	public AImage getIconoRight() {
		return iconoRight;
	}

	public void setIconoRight(AImage iconoRight) {
		this.iconoRight = iconoRight;
	}

	public AImage getImagenFront() {
		return imagenFront;
	}

	public void setImagenFront(AImage imagenFront) {
		this.imagenFront = imagenFront;
	}

	public AImage getImagenBack() {
		return imagenBack;
	}

	public void setImagenBack(AImage imagenBack) {
		this.imagenBack = imagenBack;
	}

	public AImage getImagenLeft() {
		return imagenLeft;
	}

	public void setImagenLeft(AImage imagenLeft) {
		this.imagenLeft = imagenLeft;
	}

	public AImage getImagenRight() {
		return imagenRight;
	}

	public void setImagenRight(AImage imagenRight) {
		this.imagenRight = imagenRight;
	}



	// Available themes
	//private ListModel<String> _themes = null;
	private ListModel<String> capacidadList = null;
	private ListModel<String> tipoList = null;
	private ListModel<String> displayList = null;
	private ListModel<String> colorList = null;
	private ListModel<String> sistemaOperativoList = null;
	private ListModel<String> carrierList = null;
	private ListModel<String> marcaList = null;
	
	
	private void loadCatalogos(){
		
		List<String> capacidades = new ArrayList<String>();
		capacidades.add("16GB");
		capacidades.add("32GB");
		capacidades.add("64GB");
		capacidadList = new ListModelList(capacidades);
		
		List<String> tipos = new ArrayList<String>();
		tipos.add("SLIDER");
		tipos.add("BASIC PHONE");
		tipos.add("BAR");
		tipos.add("SMART PHONE");
		tipos.add("TOUCHsCREEN");
		tipos.add("FLIP");
		tipoList = new ListModelList(tipos);
		
		List<String> displays = new ArrayList<String>();
		displays.add("3.5");
		displays.add("4.5");
		displays.add("5.5");
		displays.add("6.5");	
		displayList = new ListModelList(displays);
		
		List<String> colors = new ArrayList<String>();
		colors.add("BLANCO");
		colors.add("ROJO");
		colors.add("GRIS");
		colors.add("NEGRO");
		colors.add("PLATA");
		colorList = new ListModelList(colors);
		
		
		List<String> sistemasOperativos = new ArrayList<String>();
		sistemasOperativos.add("ANDROID");
		sistemasOperativos.add("WINDOWS MOBILE");
		sistemasOperativos.add("IOS");
		sistemaOperativoList = new ListModelList(sistemasOperativos);
		
		List<String> carriers = new ArrayList<String>();
		carriers.add("MOVISTAR");
		carrierList = new ListModelList(carriers);
		
		List<String> marcas = new ArrayList<String>();
		marcas.add("APPLE");
		marcas.add("HTC");
		marcas.add("LG");
		marcas.add("MOTOROLA");
		marcas.add("NOKIA");
		marcas.add("SAMSUNG");
		marcas.add("SONY");
		marcaList = new ListModelList(marcas);		
		
	}
	// Current theme name
	private String currentTheme = null;

	/*public ListModel<String> getThemes() {
		return _themes;
	}*/

	public String getCurrentTheme() {
		return currentTheme;
	}

	@NotifyChange("currentTheme")
	public void setCurrentTheme(String currentTheme) {
		this.currentTheme = currentTheme;
	}

	public ProductoDataFilter getProductoDataFilter() {
		return dataFilter;
	}

	public void setProductoDataFilter(ProductoDataFilter dataFilter) {
		this.dataFilter = dataFilter;
	}

	public Producto getSelectedRecord() {
		return selectedRecord;
	}

	public void setSelectedRecord(Producto selectedRecord) {
		this.selectedRecord = selectedRecord;
	}

	public String getRecordMode() {
		return recordMode;
	}

	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}

	public boolean isMakeAsReadOnly() {
		return makeAsReadOnly;
	}

	public void setMakeAsReadOnly(boolean makeAsReadOnly) {
		this.makeAsReadOnly = makeAsReadOnly;
	}

	@AfterCompose
	@NotifyChange({"iconoFront","iconoBack","iconoLeft","iconoRight","imagenFront","imagenBack","imagenLeft","imagenRight"})
	
	public void initSetup(@ContextParam(ContextType.VIEW) Component view,
			@ExecutionArgParam("selectedRecord") Producto celularProducto,
			@ExecutionArgParam("recordMode") String recordMode,
			@ExecutionArgParam("centerArea") Center centerArea)
			throws IOException {

		Selectors.wireComponents(view, this, false);
		setRecordMode(recordMode);
		CRUDService = (CRUDService) SpringUtil.getBean("CRUDService");
		this.centerArea = centerArea;	
		this.loadCatalogos();
		
		iconoFront = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		iconoBack = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		iconoLeft = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		iconoRight = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		imagenFront = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		imagenBack = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		imagenLeft = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		imagenRight = new AImage(Executions.getCurrent().getDesktop().getWebApp()
				.getRealPath("/images")
				+ "/celular.jpg");
		
		
		if (recordMode.equals("NEW")) {
			this.selectedRecord = new Producto();
			this.selectedRecord.setFecha_alta(Calendar.getInstance().getTime());
			this.selectedRecord.setSystem(0);
			//this.selectedRecord.setSystem(0);
		}

		if (recordMode.equals("EDIT")) {
			this.selectedRecord = celularProducto;
			if (this.selectedRecord.getIconoFront() != null)
				iconoFront = new AImage("icono_front",
						this.selectedRecord.getIconoFront());
			if (this.selectedRecord.getIconoBack() != null)
				iconoBack = new AImage("icono_back",
						this.selectedRecord.getIconoBack());
			if (this.selectedRecord.getIconoLeft() != null)
				iconoLeft = new AImage("icono_left",
						this.selectedRecord.getIconoLeft());
			if (this.selectedRecord.getIconoRight() != null)
				iconoRight = new AImage("icono_right",
						this.selectedRecord.getIconoRight());
			if (this.selectedRecord.getImagenFront() != null)
				imagenFront = new AImage("imagen_front",
						this.selectedRecord.getImagenFront());
			if (this.selectedRecord.getImagenBack() != null)
				imagenBack = new AImage("imagen_back",
						this.selectedRecord.getImagenBack());
			if (this.selectedRecord.getImagenLeft() != null)
				imagenLeft = new AImage("imagen_left",
						this.selectedRecord.getImagenLeft());
			if (this.selectedRecord.getImagenRight() != null)
				imagenRight = new AImage("imagen_right",
						this.selectedRecord.getImagenRight());
		}

		if (recordMode == "READ") {
			setMakeAsReadOnly(true);
			this.selectedRecord = celularProducto;
			if (this.selectedRecord.getIconoFront() != null)
				iconoFront = new AImage("icono_front",
						this.selectedRecord.getIconoFront());
			if (this.selectedRecord.getIconoBack() != null)
				iconoBack = new AImage("icono_back",
						this.selectedRecord.getIconoBack());
			if (this.selectedRecord.getIconoLeft() != null)
				iconoLeft = new AImage("icono_left",
						this.selectedRecord.getIconoLeft());
			if (this.selectedRecord.getIconoRight() != null)
				iconoRight = new AImage("icono_right",
						this.selectedRecord.getIconoRight());
			if (this.selectedRecord.getImagenFront() != null)
				imagenFront = new AImage("imagen_front",
						this.selectedRecord.getImagenFront());
			if (this.selectedRecord.getImagenBack() != null)
				imagenBack = new AImage("imagen_back",
						this.selectedRecord.getImagenBack());
			if (this.selectedRecord.getImagenLeft() != null)
				imagenLeft = new AImage("imagen_left",
						this.selectedRecord.getImagenLeft());
			if (this.selectedRecord.getImagenRight() != null)
				imagenRight = new AImage("imagen_right",
						this.selectedRecord.getImagenRight());
		}
	}

	@Command
	public void saveThis(@BindingParam("action") Integer action) {

		if (MyLib.IsValidBean(this.selectedRecord) == false) {
			return;
		}
		
		if (iconoFront != null) {
			byte[] bFile = iconoFront.getByteData();
			this.selectedRecord.setIconoFront(bFile);
		} else
			this.selectedRecord.setIconoFront(null);
		if (iconoBack != null) {
			byte[] bFile = iconoBack.getByteData();
			this.selectedRecord.setIconoBack(bFile);
		} else
			this.selectedRecord.setIconoBack(null);
		if (iconoLeft != null) {
			byte[] bFile = iconoLeft.getByteData();
			this.selectedRecord.setIconoLeft(bFile);
		} else
			this.selectedRecord.setIconoLeft(null);
		if (iconoRight != null) {
			byte[] bFile = iconoRight.getByteData();
			this.selectedRecord.setIconoRight(bFile);
		} else
			this.selectedRecord.setIconoRight(null);
		if (imagenFront != null) {
			byte[] bFile = imagenFront.getByteData();
			this.selectedRecord.setImagenFront(bFile);
		} else
			this.selectedRecord.setImagenFront(null);
		if (imagenBack != null) {
			byte[] bFile = imagenBack.getByteData();
			this.selectedRecord.setImagenBack(bFile);
		} else
			this.selectedRecord.setImagenBack(null);
		if (imagenLeft != null) {
			byte[] bFile = imagenLeft.getByteData();
			this.selectedRecord.setImagenLeft(bFile);
		} else
			this.selectedRecord.setImagenLeft(null);
		if (imagenRight != null) {
			byte[] bFile = imagenRight.getByteData();
			this.selectedRecord.setImagenRight(bFile);
		} else
			this.selectedRecord.setImagenRight(null);
		
		this.selectedRecord.setSystem(0);
		this.selectedRecord.setFecha_modificacion(Calendar.getInstance().getTime());
		UserProfile dbUser = FHSessionUtil.getCurrentUser();
		this.selectedRecord.setUsuario(dbUser.getFirstName()+" "+dbUser.getLastName());
			
		CRUDService.Save(this.selectedRecord);
		MyLib.showSuccessmessage();
		
		if (action == 0) {
			final HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("centerArea", centerArea);
			centerArea.getChildren().clear();
			Executions.createComponents("celularList.zul", centerArea, map);
		}
		if (action == 1) {
			this.selectedRecord = new Producto();
			
			iconoFront = null;			
			iconoBack  = null;			
			iconoLeft  = null;			
			iconoRight = null;			
			imagenFront = null;			
			imagenBack  = null;			
			imagenLeft  = null;			
			imagenRight = null;
			BindUtils.postNotifyChange(null, null, CelularCRUDVM.this,
					"selectedRecord");
		}
	}

	@Command
	public void cancel() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("centerArea", centerArea);
		centerArea.getChildren().clear();
		Executions.createComponents("celularList.zul", centerArea, map);
	}

	@Command
	@NotifyChange({"iconoFront","iconoBack","iconoLeft","iconoRight","imagenFront","imagenBack","imagenLeft","imagenRight"})
	public void removeImage(@BindingParam("imagen") String imagen) {

		if(imagen.equalsIgnoreCase("iconoFront"))
			iconoFront = null;
		if(imagen.equalsIgnoreCase("iconoBack"))
			iconoBack  = null;
		if(imagen.equalsIgnoreCase("iconoLeft"))
			iconoLeft  = null;
		if(imagen.equalsIgnoreCase("iconoRight"))
			iconoRight = null;
		if(imagen.equalsIgnoreCase("iconoFront"))
			imagenFront = null;
		if(imagen.equalsIgnoreCase("imagenBack"))
			imagenBack  = null;
		if(imagen.equalsIgnoreCase("imagenLeft"))
			imagenLeft  = null;
		if(imagen.equalsIgnoreCase("imagenRight"))
			imagenRight = null;
	}

	@Command
	@NotifyChange({"iconoFront","iconoBack","iconoLeft","iconoRight","imagenFront","imagenBack","imagenLeft","imagenRight"})
	public void upload(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@BindingParam("imagen") String imagen) {

		UploadEvent upEvent = null;
		Object objUploadEvent = ctx.getTriggerEvent();
		if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
			upEvent = (UploadEvent) objUploadEvent;
		}
		if (upEvent != null) {
			Media media = upEvent.getMedia();
			int lengthofImage = media.getByteData().length;
			if (media instanceof Image) {
				if (lengthofImage > 500 * 1024) {
					Messagebox
							.show("El tamaño de la imagen debe ser menor a 500Kb.");
					return;
				} else {
					upEvent.getName();
					
					if(imagen.equalsIgnoreCase("iconoFront"))
						iconoFront = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also
					if(imagen.equalsIgnoreCase("iconoBack"))
						iconoBack  = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also
					if(imagen.equalsIgnoreCase("iconoLeft"))
						iconoLeft  = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also
					if(imagen.equalsIgnoreCase("iconoRight"))
						iconoRight = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also
					if(imagen.equalsIgnoreCase("imagenFront"))
						imagenFront = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also
					if(imagen.equalsIgnoreCase("imagenBack"))
						imagenBack  = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also
					if(imagen.equalsIgnoreCase("imagenLeft"))
						imagenLeft  = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also
					if(imagen.equalsIgnoreCase("imagenRight"))
						imagenRight = (AImage) media;// Initialize the bind object to show image in zul page and Notify it also															 
				}
			} else {
				Messagebox.show("El archivo seleccionado no es una imagen.");
			}
		}
	}

	public ListModel<String> getCapacidadList() {
		return capacidadList;
	}

	public ListModel<String> getTipoList() {
		return tipoList;
	}

	public ListModel<String> getDisplayList() {
		return displayList;
	}

	public ListModel<String> getColorList() {
		return colorList;
	}

	public ListModel<String> getSistemaOperativoList() {
		return sistemaOperativoList;
	}

	public ListModel<String> getCarrierList() {
		return carrierList;
	}

	public ListModel<String> getMarcaList() {
		return marcaList;
	}
	
	

}
