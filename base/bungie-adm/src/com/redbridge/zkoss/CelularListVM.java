package com.redbridge.zkoss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Center;
import org.zkoss.zul.Messagebox;

import com.redbridge.domain.Producto;
import com.redbridge.service.CRUDService;
import com.redbridge.utilities.ConfirmResponse;
import com.redbridge.utilities.MyLib;

public class CelularListVM implements ConfirmResponse,Serializable {

	private Center centerArea;
	private ProductoDataFilter dataFilter = new ProductoDataFilter();

	@WireVariable
	private CRUDService CRUDService;

	private Producto selectedItem;
	private List<Producto> allReordsInDB = null;
	private List<Producto> productoList = null;

	public Producto getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Producto selectedItem) {
		this.selectedItem = selectedItem;
	}

	public ProductoDataFilter getDataFilter() {
		return dataFilter;
	}

	public void setDataFilter(ProductoDataFilter dataFilter) {
		this.dataFilter = dataFilter;
	}

	@AfterCompose
	public void initSetup(@ContextParam(ContextType.VIEW) Component view,
			@ExecutionArgParam("centerArea") Center centerArea) {
		Selectors.wireComponents(view, this, false);
		this.centerArea = centerArea;
		CRUDService = (CRUDService) SpringUtil.getBean("CRUDService");
		allReordsInDB = CRUDService.getAll(Producto.class);
		productoList = new ArrayList<Producto>((allReordsInDB));

	}

	public List<Producto> getDataSet() {
		return allReordsInDB;
	}

	@Command
	public void onAddNew() {
		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("selectedRecord", null);
		map.put("recordMode", "NEW");
		map.put("centerArea", centerArea);
		centerArea.getChildren().clear();
		Executions.createComponents("CelularCRUD.zul", centerArea, map);
	}

	@Command
	public void onEdit(@BindingParam("celularRecord") Producto celularProducto) {

		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("selectedRecord", celularProducto);
		map.put("recordMode", "EDIT");
		map.put("centerArea", centerArea);
		centerArea.getChildren().clear();
		Executions.createComponents("CelularCRUD.zul", centerArea, map);
	}

	@Command
	public void openAsReadOnly(
			@BindingParam("celularRecord") Producto celularProducto) {

		final HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("selectedRecord", celularProducto);
		map.put("recordMode", "READ");
		map.put("centerArea", centerArea);
		centerArea.getChildren().clear();
		Executions.createComponents("CelularCRUD.zul", centerArea, map);
	}

	@Command
	public void onDelete(@BindingParam("celularRecord") Producto celularProducto) {
		MyLib.confirm("deleteFirstConfirm", "El Celular Seleccionado  \""
				+ selectedItem.getCodigo() + "\" será eliminado.?",
				"Confirmación", this);

	}

	@NotifyChange("dataSet")
	@Command
	public void doFilter() {
		allReordsInDB = new ArrayList<Producto>();
		;
		for (Iterator<Producto> i = productoList.iterator(); i.hasNext();) {
			Producto tmp = i.next();
			if (tmp.getNombre().toLowerCase()
					.indexOf(dataFilter.getNombre().toLowerCase()) == 0
					&& tmp.getMarca().toLowerCase()
							.indexOf(dataFilter.getMarca().toLowerCase()) == 0
					&& tmp.getTipo().toLowerCase()
							.indexOf(dataFilter.getTipo().toLowerCase()) == 0
					&& tmp.getCapacidad().toLowerCase()
							.indexOf(dataFilter.getCapacidad().toLowerCase()) == 0
					&& tmp.getColor().toLowerCase()
							.indexOf(dataFilter.getColor().toLowerCase()) == 0) {
				allReordsInDB.add(tmp);

			}
		}

	}

	@Command
	public void Logout() {
		Executions.sendRedirect("/j_spring_security_logout");
	}

	@Override
	public void onConfirmClick(String code, int button) {
		if (code.equals("deleteFirstConfirm") && button == Messagebox.YES) {
			MyLib.confirm(
					"deleteSecondConfirm",
					"El Celular:  \""
							+ selectedItem.getCodigo()
							+ "\" sera eliminado permanentemente..?",
					"Confirmación", this);
		}
		if (code.equals("deleteSecondConfirm") && button == Messagebox.YES) {

			CRUDService.delete(selectedItem);

			allReordsInDB.remove(allReordsInDB.indexOf(selectedItem));
			BindUtils.postNotifyChange(null, null, CelularListVM.this, "dataSet");
			MyLib.showSuccessmessage();

		}
	}

}
