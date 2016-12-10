package com.redbridge.service.util;

public class Format {
	
	
	public static String formatDinero(Double number){		
		String value = String.format("%1$.2f",number);
		return value;
	}
	
	
	
	    public static void main(String[] args) {

		double number = 2221.23456;
		// Specify precision with format.
		String value = String.format("%1$.2f",number);
		System.out.println(value);
	    }
	

}
