package com.redbridge.webservice;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class WebClientBungie {
	
	// Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8090/externalservices/";
	
	private WebTarget target;
	
	public String getRestBanorte(String id){
		String responseMsg = "CONEXION BANORTE RECHAZADA";
		try{
			Client c = ClientBuilder.newClient();
			target = c.target(BASE_URI);
			responseMsg = target.path("banorte/101").request().get(String.class);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return responseMsg;
	}
	
	public String getRestDHL(String id){
		String responseMsg = "CONEXION DHL RECHAZADA";
		try{
			Client c = ClientBuilder.newClient();
			target = c.target(BASE_URI);
			responseMsg = target.path("dhl/101").request().get(String.class);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return responseMsg;
	}
	
	public static void main(String[] args){
		
		WebClientBungie webclient = new WebClientBungie();
		
		System.out.println("WebService DHL:"+webclient.getRestDHL("101"));
		System.out.println("WebService DHL:"+webclient.getRestBanorte("101"));
		
	}
	

}
