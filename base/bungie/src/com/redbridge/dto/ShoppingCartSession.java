package com.redbridge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.redbridge.entity.CapacidadEntity;
import com.redbridge.entity.ColorEntity;
import com.redbridge.entity.ProductoEntity;
import com.redbridge.entity.UsuarioEntity;
import com.redbridge.entity.VentaProductoEntity;
import com.redbridge.service.util.Format;

public class ShoppingCartSession implements Serializable{

	private int id;
	private UsuarioEntity  usuario;
	
	private int cantidad;
	
	private HashMap<String,VentaProductoEntity> dhl;
	private List<ProductoEntity> productos;
	
	public ShoppingCartSession(){
		productos = new ArrayList<ProductoEntity>(); 
		dhl = new HashMap<String,VentaProductoEntity>(); 
	}
	
	public int getCantidad() {
		return productos.size();
	}
		
	public void addProducto(ProductoEntity producto) {		
		productos.add(producto);
	}
	
	public void deleteProducto(int index) {		
		productos.remove(index);		
	}
	
	public String getSubtotal(){
		
		Double subtotal = 0d;		
		for(ProductoEntity producto:productos){			
			subtotal += producto.getPrecio().doubleValue();					
		}
		return Format.formatDinero(subtotal);
	}

	public List<ProductoEntity> getProductos() {
		return productos;
	}

	
	
}
